package com.tsj.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;

public class HttpUtils {

    /**
     * get
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @return
     * @throws Exception
     */
    public static HttpResponse doGet(String host, String path, String method,
                                     Map<String, String> headers,
                                     Map<String, String> querys)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpGet request = new HttpGet(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        return httpClient.execute(request);
    }

    /**
     * post form
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param bodys
     * @return
     * @throws Exception
     */
    public static HttpResponse doPost(String host, String path, String method,
                                      Map<String, String> headers,
                                      Map<String, String> querys,
                                      Map<String, String> bodys)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPost request = new HttpPost(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (bodys != null) {
            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();

            for (String key : bodys.keySet()) {
                nameValuePairList.add(new BasicNameValuePair(key, bodys.get(key)));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
            formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
            request.setEntity(formEntity);
        }

        return httpClient.execute(request);
    }

    /**
     * Post String
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param body
     * @return
     * @throws Exception
     */
    public static HttpResponse doPost(String host, String path, String method,
                                      Map<String, String> headers,
                                      String body)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPost request = new HttpPost(buildUrl(host, path, new HashMap<String, String>()));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (body != null && body.trim().length()>0) {
            request.setEntity(new StringEntity(body, "utf-8"));
        }

        return httpClient.execute(request);
    }

    /**
     * Post stream
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param body
     * @return
     * @throws Exception
     */
    public static HttpResponse doPost(String host, String path, String method,
                                      Map<String, String> headers,
                                      Map<String, String> querys,
                                      byte[] body)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPost request = new HttpPost(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (body != null) {
            request.setEntity(new ByteArrayEntity(body));
        }

        return httpClient.execute(request);
    }

    /**
     * Put String
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param body
     * @return
     * @throws Exception
     */
    public static HttpResponse doPut(String host, String path, String method,
                                     Map<String, String> headers,
                                     Map<String, String> querys,
                                     String body)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPut request = new HttpPut(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (body != null && body.trim().length()>0) {
            request.setEntity(new StringEntity(body, "utf-8"));
        }

        return httpClient.execute(request);
    }

    /**
     * Put stream
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @param body
     * @return
     * @throws Exception
     */
    public static HttpResponse doPut(String host, String path, String method,
                                     Map<String, String> headers,
                                     Map<String, String> querys,
                                     byte[] body)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpPut request = new HttpPut(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        if (body != null) {
            request.setEntity(new ByteArrayEntity(body));
        }

        return httpClient.execute(request);
    }

    /**
     * Delete
     *
     * @param host
     * @param path
     * @param method
     * @param headers
     * @param querys
     * @return
     * @throws Exception
     */
    public static HttpResponse doDelete(String host, String path, String method,
                                        Map<String, String> headers,
                                        Map<String, String> querys)
            throws Exception {
        HttpClient httpClient = wrapClient(host);

        HttpDelete request = new HttpDelete(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        return httpClient.execute(request);
    }

    private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(host);
        if (path != null && path.trim().length()>0) {
            sbUrl.append(path);
        }
        if (null != querys) {
            StringBuilder sbQuery = new StringBuilder();
            for (Map.Entry<String, String> query : querys.entrySet()) {
                if (0 < sbQuery.length()) {
                    sbQuery.append("&");
                }
                if ((query.getKey()== null || query.getKey() == "") && (query.getValue() != null && query.getValue().trim().length()>0)) {
                    sbQuery.append(query.getValue());
                }
                if (query.getKey() != null && query.getKey().trim().length()>0) {
                    sbQuery.append(query.getKey());
                    if (query.getValue() != null && query.getValue().trim().length()>0) {
                        sbQuery.append("=");
                        sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                    }
                }
            }
            if (0 < sbQuery.length()) {
                sbUrl.append("?").append(sbQuery);
            }
        }

        return sbUrl.toString();
    }

    private static HttpClient wrapClient(String host) {
        HttpClient httpClient = new DefaultHttpClient();
        if (host.startsWith("https://")) {
            sslClient(httpClient);
        }

        return httpClient;
    }

    private static void sslClient(HttpClient httpClient) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] xcs, String str) {

                }
                public void checkServerTrusted(X509Certificate[] xcs, String str) {

                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = httpClient.getConnectionManager();
            SchemeRegistry registry = ccm.getSchemeRegistry();
            registry.register(new Scheme("https", 443, ssf));
        } catch (KeyManagementException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 生成包体加密密钥串
     * @param jsonObject 包体json字符串
     * @param appSecret 签悦分配的apiSecret
     * @return
     */
    public static String createSignature(String jsonObject, String appSecret){
        String contentSignature = "";
        try {
            //初始化HMAC密钥
            String HMAC_SHA1_ALGORITHM = "HmacSHA1";
            //得到一个指定算法密钥的密钥生成器
            Key signingKey = new SecretKeySpec(appSecret.getBytes(), HMAC_SHA1_ALGORITHM);
            //生成一个指定Mac算法的Mac对象
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            //用给定密钥初始化Mac对象
            mac.init(signingKey);
            //获得包体json字符串
//            String jsonStr = JSONObject.parseObject(jsonObject.toString()).toString();
            String jsonStr = jsonObject.toString();
            //包体json字符串转byte[]类型
            byte[] rawData = jsonStr.getBytes("utf-8");
            ////完成Mac操作
            byte[] rawHmac = mac.doFinal(rawData);
            //生成包体加密密钥串gi
           // contentSignature = "HMAC-SHA1 " + new String(new Base64Encoder().encode(rawHmac));
            contentSignature = "HMAC-SHA1 " + new String(Base64.getEncoder().encode(rawHmac));


        }catch (Exception e){
            e.printStackTrace();
        }
        return contentSignature;
    }

    public static void main(String[] src){
        String contentSignature = "";
        try {
            //初始化HMAC密钥
            String HMAC_SHA1_ALGORITHM = "HmacSHA1";
            //得到一个指定算法密钥的密钥生成器
            Key signingKey = new SecretKeySpec("8235543db4a511e7a965005056bfcc6b".getBytes(), HMAC_SHA1_ALGORITHM);
            //生成一个指定Mac算法的Mac对象
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            //用给定密钥初始化Mac对象
            mac.init(signingKey);
            //获得包体json字符串
            String jsonStr = "{\"registerType\":\"1\",\"userName\":\"17801098970\",\"password\":\"1234qwer\",\"signPassword\":\"1234qwer\",\"apiUserAuthenticationVo\":{\"reaName\":\"张达\",\"certificateType\":\"0\",\"certificateNo\":\"371481199808146631\",\"contactPersonName\":\"\",\"contactPersonIdCard\":\"\",\"contactPhoneNumber\":\"\"}}";
            //包体json字符串转byte[]类型
            byte[] rawData = jsonStr.getBytes("utf-8");
            ////完成Mac操作
            byte[] rawHmac = mac.doFinal(rawData);
//            String hexBytes = byte2hex(rawHmac);
            System.out.print(new String(new Base64Encoder().encode(rawHmac)));
            //生成包体加密密钥串
//            contentSignature = "HMAC-SHA1 " + new String(new Base64Encoder().encode(rawHmac));

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}