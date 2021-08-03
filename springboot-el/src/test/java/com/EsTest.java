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
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.cardinality.Cardinality;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author tansj
 * @Date 2021/6/2 下午3:13
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootELApplication.class)
@Slf4j
public class EsTest {

    @Autowired
    private TransportClient transportClient;

    String index = "test_index";
    String type = "test_type";

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
                    .field("name", i)
                    .field("age", new Random().nextInt(100))
                    .endObject();
            IndexResponse indexResponse = indexRequestBuilder.setId(String.valueOf(i)).setSource(xContentBuilder).get();
            log.info("添加数据：{}", indexResponse.getVersion());
        }
    }

    @Test
    public void removeData() {
        for (int i = 1; i <= 10; i++) {
            DeleteResponse deleteResponse = transportClient.prepareDelete(index, type, String.valueOf(i)).execute().actionGet();
        }
    }


    @Test
    public void getAllData() {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        SearchResponse searchResponse = transportClient.prepareSearch(index).setTypes(type).setQuery(queryBuilder).get();
        for (SearchHit hit : searchResponse.getHits()) {
            System.out.println(hit.getSourceAsMap());
//            System.out.println(hit.getId());
//            DeleteResponse deleteResponse = transportClient.prepareDelete(index, type, hit.getId()).execute().actionGet();
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
        searchRequestBuilder.setFetchSource("name", null);
        SearchResponse searchResponse = searchRequestBuilder.setQuery(queryBuilder).execute().actionGet();
        for (SearchHit hit : searchResponse.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    @Test
    public void getDataByHighlightFiled() {
        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch(index);

        //设置查询
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        searchRequestBuilder.setQuery(queryBuilder);

        //需要显示的字段
        searchRequestBuilder.setFetchSource("name,age".split(","), null);

        //设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        highlightBuilder.preTags("<span style='color:red' >");
        highlightBuilder.postTags("</span>");
        highlightBuilder.requireFieldMatch(false);
        searchRequestBuilder.highlighter(highlightBuilder);

        //分页
        searchRequestBuilder.setFrom(0).setSize(10);
        //排序
        searchRequestBuilder.addSort("age", SortOrder.DESC);

        SearchResponse searchResponse = searchRequestBuilder.get();

        long totalHits = searchResponse.getHits().totalHits;
        long length = searchResponse.getHits().getHits().length;
        log.debug("共查询到[{}]条数据,处理数据条数[{}]", totalHits, length);
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<Map<String, Object>> sourceList = new ArrayList<>();
        for (SearchHit searchHit : hits) {
            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
            HighlightField content = highlightFields.get("name");
            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
            if (content != null) {
                Text[] fragments = content.fragments();
                StringBuffer sb = new StringBuffer();
                for (Text text : fragments) {
                    sb.append(text);
                }
                //替换掉原来的内容
                sourceAsMap.put("name", sb.toString());
            }
            sourceList.add(sourceAsMap);
        }
        System.out.println(sourceList);
    }


    @Test
    public void avgAggregationBuilder() {
        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch(index);
        AggregationBuilder aggregationBuilder = AggregationBuilders.cardinality("ageCardinality").field("age");
//        AggregationBuilder aggregationBuilder2 = AggregationBuilders.sum("ageSum").field("age");
//        AggregationBuilder aggregationBuilder3 = AggregationBuilders.min("ageMin").field("age");
//        AggregationBuilder aggregationBuilder4 = AggregationBuilders.max("ageMax").field("age");
//        AggregationBuilder aggregationBuilder5 = AggregationBuilders.avg("ageAvg").field("age");
        SearchResponse searchResponse = searchRequestBuilder.addAggregation(aggregationBuilder
//                .subAggregation(aggregationBuilder2)
//                .subAggregation(aggregationBuilder3)
//                .subAggregation(aggregationBuilder4)
//                .subAggregation(aggregationBuilder5)
        )
                .get();
        Aggregations aggregations = searchResponse.getAggregations();
        Cardinality cardinality = aggregations.get("ageCardinality");
        System.out.println(cardinality.getValue());
    }


}
