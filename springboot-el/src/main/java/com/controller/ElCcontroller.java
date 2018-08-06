package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.utils.ElasticsearchUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2018/8/2
 * Time: 下午9:30
 */
@Controller
public class ElCcontroller {
    @RequestMapping("/test")
    @ResponseBody
    public String testel() {
        Map<String, Object> map = new HashMap<String, Object>(16);

        map.put("year", 1885);
        map.put("name", "tan shaojun ");
        map.put("lyrics", "Fa la la la la");


//        String s = ElasticsearchUtils.addData(JSONObject.parseObject(JSONObject.toJSONString(map)), "test", "tst",
//                "id=" + 3);
//        System.out.println(s);
//        boolean tan = ElasticsearchUtils.isIndexExist("test");
//        System.out.println(tan);
        //{"year":1885,"name":"Deck the Halls","lyrics":"Fa la la la la"}
//        List<Map<String, Object>> list = ElasticsearchUtils.searchListData("test", "tst", 1024, "", "name=你好");
        List<Map<String, Object>> dataByillegible = ElasticsearchUtils.getDataByillegible();
        return JSONObject.toJSONString(dataByillegible);
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
