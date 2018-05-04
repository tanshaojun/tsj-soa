package com.tsj.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created  on 2016/7/6.
 */
public class HttpClientUtil {

    public static String getResponseByPost(String url, Map<String, String> params) {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        BufferedReader in = null;
        String resultStr = "";


        try {
            RequestConfig requestconfig = RequestConfig.custom()
                    .setSocketTimeout(5000).setConnectionRequestTimeout(5000).setConnectTimeout(5000).build();
            httpPost.setConfig(requestconfig);
            if (params != null && params.size() > 0) {
                List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
                response = client.execute(httpPost);

                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    in = new BufferedReader(new InputStreamReader(responseEntity.getContent(), "UTF-8"));
                    String tmpl;
                    StringBuffer stringBuffer=new StringBuffer(resultStr);
                    while ((tmpl = in.readLine()) != null) {
                       // resultStr += tmpl;
                        stringBuffer= stringBuffer.append(tmpl);
                    }
                    resultStr=stringBuffer.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpPost.abort();
                if (in != null) {
                    in.close();
                }
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return resultStr;
    }

    public static String getResponseByGet(String url) {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        BufferedReader in = null;
        String resultStr = "";

        try {
            RequestConfig requestconfig = RequestConfig.custom()
                    .setSocketTimeout(5000).setConnectionRequestTimeout(5000).setConnectTimeout(5000).build();
            httpGet.setConfig(requestconfig);
            response = client.execute(httpGet);

            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                in = new BufferedReader(new InputStreamReader(responseEntity.getContent(), "UTF-8"));
                String tmpl;
                StringBuffer stringBuffer=new StringBuffer(resultStr);
                while ((tmpl = in.readLine()) != null) {
                   // resultStr += tmpl;
                    stringBuffer= stringBuffer.append(tmpl);
                }
                resultStr=stringBuffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpGet.abort();
                if (in != null) {
                    in.close();
                }
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultStr;
    }

}
