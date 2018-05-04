package com.tsj.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientUtils {

    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private final static Object syncLock = new Object();
    private static HttpClientConfiguration config = null;
    private static CloseableHttpClient httpClient = null;

    static {
        config = new HttpClientConfiguration();
    }

    private static void config(HttpRequestBase httpRequestBase) {
        httpRequestBase.setHeader("User-Agent", config.getUserAgent());

        // 配置请求的超时设置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(config.getConnectionRequestTimeout())
                .setConnectTimeout(config.getConnectionTimeout()).setSocketTimeout(config.getSocketTimeout()).build();
        httpRequestBase.setConfig(requestConfig);
    }

    public static CloseableHttpClient getHttpClient(String url) {
        String hostname = url.split("/")[2];
        int port = 80;
        if (hostname.contains(":")) {
            String[] arr = hostname.split(":");
            hostname = arr[0];
            port = Integer.parseInt(arr[1]);
        }
        if (httpClient == null) {
            synchronized (syncLock) {
                if (httpClient == null) {
                    httpClient = createHttpClient(config.getMaxConnections(), config.getMaxConnections(), hostname,
                            port);
                }
            }
        }
        return httpClient;
    }

    public static CloseableHttpClient createHttpClient(int maxTotal, int maxPerRoute, String hostname, int port) {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainsf).register("https", sslsf).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
        // 将最大连接数增加
        cm.setMaxTotal(maxTotal);
        HttpHost httpHost = new HttpHost(hostname, port);
        // 将目标主机的最大连接数增加
        cm.setMaxPerRoute(new HttpRoute(httpHost), maxPerRoute);

        // 请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount >= config.getMaxRetries()) {// 如果已经重试了5次，就放弃
                    return false;
                }

                logger.error(exception.getMessage());
                if (exception instanceof NoHttpResponseException) {
                    logger.error("[retryRequest] NoHttpResponseException occurred executionCount={} retry request",
                            executionCount);
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
                    logger.error("[retryRequest] SSLHandshakeException occurred executionCount={} not retry request",
                            executionCount);
                    return false;
                }
                if (exception instanceof InterruptedIOException) {// 超时
                    logger.error("[retryRequest] InterruptedIOException occurred executionCount={} not retry request",
                            executionCount);
                    return false;
                }
                if (exception instanceof UnknownHostException) {// 目标服务器不可达
                    logger.error("[retryRequest] UnknownHostException occurred executionCount={} not retry request",
                            executionCount);
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
                    logger.error("[retryRequest] ConnectTimeoutException occurred executionCount={} not retry request",
                            executionCount);
                    return false;
                }
                if (exception instanceof SSLException) {// SSL握手异常
                    logger.error("[retryRequest] SSLException occurred executionCount={} not retry request",
                            executionCount);
                    return false;
                }

                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };

        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm)
                .setRetryHandler(httpRequestRetryHandler)
                .setServiceUnavailableRetryStrategy(
                        new HttpServiceUnavailableRetryStrategy(config.getMaxRetries(), config.getRetryInterval()))
                .build();
        return httpClient;
    }

    private static void setPostParams(HttpPost httpost, Map<String, Object> params) {
        List<NameValuePair> nvps = Lists.newArrayList();

        if (MapUtils.isNotEmpty(params)) {
            Set<Map.Entry<String, Object>> entrySet = params.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
        }
        try {
            httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("[setPostParams] UrlEncodedFormEntity an exception occurred charset='UTF-8'", e);
        }
    }

    private static String sendRequest(String url, HttpUriRequest request) throws IOException {
        CloseableHttpResponse response = null;
        try {
            response = getHttpClient(url).execute(request, HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            return result;
        } catch (Exception e) {
            logger.error("[sendRequest] execute request failed url={}", url);
            throw e;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error("[sendRequest] response close", e);
            }
        }
    }

    public static String post(String url, Map<String, Object> params) throws IOException {
        HttpPost httppost = new HttpPost(url);
        config(httppost);
        setPostParams(httppost, params);

        return sendRequest(url, httppost);
    }

    public static String postJSON(String url, String jsonStr) throws IOException {
        HttpPost httppost = new HttpPost(url);
        config(httppost);
        httppost.addHeader("content-type", "application/json");

        StringEntity params = new StringEntity(jsonStr.toString(), Consts.UTF_8);
        httppost.setEntity(params);
        return sendRequest(url, httppost);
    }

    public static String postObject(String url, Object obj) throws IOException {
        HttpPost httppost = new HttpPost(url);
        config(httppost);
        httppost.addHeader("content-type", "application/json");

        JsonMapper mapper = JsonMapper.getInstance();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        String jsonStr = mapper.toJson(obj);

        StringEntity params = new StringEntity(jsonStr.toString(), Consts.UTF_8);
        httppost.setEntity(params);
        return sendRequest(url, httppost);
    }

    public static String get(String url) throws IOException {
        HttpGet httpget = new HttpGet(url);
        config(httpget);

        return sendRequest(url, httpget);
    }

    public static String electronicSignaturePost(String url, Map<String, Object> paramMap,String jsonStr) throws IOException {
        HttpPost httppost = new HttpPost(url);
        config(httppost);
        httppost.addHeader("hostname", (String)paramMap.get("hostName"));
        httppost.addHeader("apiId", (String)paramMap.get("apiId"));
        httppost.addHeader("content-type", "application/json");
        httppost.addHeader("content-Signature", (String)paramMap.get("contentSignature"));
        httppost.addHeader("Timestamp", (String)paramMap.get("timestamp"));
        StringEntity params = new StringEntity(jsonStr, Consts.UTF_8);
        //System.out.println(JSONObject.toJSONString(paramMap).toString());
        httppost.setEntity(params);
        return sendRequest(url, httppost);
    }

}
