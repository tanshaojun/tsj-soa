package com;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @Author tansj
 * @Date 2021/6/2 下午3:13
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringBootELApplication.class)
@Slf4j
public class EsTest {

    private TransportClient transportClient;

    String index = "test_index";
    String type = "test_type";

    @Before
    public void init() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "docker-cluster")
                .build();
        transportClient = new PreBuiltTransportClient(settings);
        TransportAddress inetSocketTransportAddress = new TransportAddress(InetAddress.getByName("127.0.0.1"),
                Integer.valueOf(9300));
        transportClient.addTransportAddresses(inetSocketTransportAddress);
        log.info("init success");
    }

    @Test
    public void addIndex() {
        boolean exists = transportClient.admin().indices().exists(new IndicesExistsRequest(index)).actionGet().isExists();
        if (!exists) {
            CreateIndexResponse createIndexResponse = transportClient.admin().indices().prepareCreate(index).execute().actionGet();
            log.info("执行建立：{}", createIndexResponse.isAcknowledged());
        } else {
            log.error("索引已建立");
        }
    }

    @Test
    public void addMapping() throws IOException {
        //standard 标准分词
        //ik_max_word ik分词
        //ik_smart ik分词
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                .startObject()
                .startObject("properties")
                .startObject("title")
                // 指定类型
                .field("type", "text")
                //添加分词
                .field("analyzer", "ik_max_word")
                .endObject()
                .endObject()
                .endObject();
        PutMappingRequest putMappingRequest = Requests.putMappingRequest(index).type(type).source(xContentBuilder);
        PutMappingResponse putMappingResponse = transportClient.admin().indices().putMapping(putMappingRequest).actionGet();
        log.info("添加分词成功：{}", putMappingResponse.isAcknowledged());
    }

    @Test
    public void removeIndex() {
        boolean acknowledged = transportClient.admin().indices().prepareDelete(index).execute().actionGet().isAcknowledged();
        log.info("删除索引是否成功：{}", acknowledged);
    }

    @Test
    public void addData() throws IOException {
        IndexRequestBuilder indexRequestBuilder = transportClient.prepareIndex(index, type);
        for (int i = 1; i <= 10; i++) {
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("id", String.valueOf(i))
                    .field("name", "张")
                    .field("age", new Random().nextInt(100))
                    .endObject();
            IndexResponse indexResponse = indexRequestBuilder.setId(String.valueOf(i)).setSource(xContentBuilder).get();
            log.info("添加数据：{}", indexResponse.getVersion());
        }
    }

    @Test
    public void removeData() {
        DeleteResponse deleteResponse = transportClient.prepareDelete(index, type, "1").execute().actionGet();
    }


    @Test
    public void getAllData() {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        SearchResponse searchResponse = transportClient.prepareSearch(index).setTypes(type).setQuery(queryBuilder).get();
        for (SearchHit hit : searchResponse.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    @Test
    public void getDataByFiled() {
        //匹配查询
        //QueryBuilder queryBuilder = QueryBuilders.matchQuery("id", "1");
        //分词查询
        //QueryBuilder queryBuilder = QueryBuilders.termQuery("id", "1");
        //范围查询
        //QueryBuilder queryBuilder = QueryBuilders.rangeQuery("age").gt(50).lt(100);
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch(index);
        searchRequestBuilder.setFetchSource("name",null);
        SearchResponse searchResponse = searchRequestBuilder.setQuery(queryBuilder).get();
        for (SearchHit hit : searchResponse.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

}
