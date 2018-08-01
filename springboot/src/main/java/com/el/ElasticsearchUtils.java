package com.el;


import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticsearchUtils {

    private final static String INDEX = "test";
    private final static String TYPE = "emp";

    public static TransportClient getClient() throws UnknownHostException {
        return new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }

    public static void main(String[] args) {
        TransportClient client = null;
        try {
            client = getClient();
            IndexResponse indexResponse = client.prepareIndex(INDEX, TYPE, "2").setSource("{ \"name\": \"Deck the " +
                    "Halls\", \"year\": " +
                    "1875, \"lyrics\": \"Fa la la la la\" }").execute().actionGet();
            System.out.println("index: " + indexResponse.getIndex() + " insert doc id: " + indexResponse.getId());
            GetResponse getFields = client.prepareGet(INDEX, TYPE, "2").execute().actionGet();
            System.out.println(getFields.getSourceAsString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
