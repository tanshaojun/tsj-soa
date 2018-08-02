package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.utils.ElasticsearchUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
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
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "鹏磊" + 1);
        map.put("age", 1);
        map.put("interests", new String[]{"阅读", "学习"});
        map.put("about", "世界上没有优秀的理念，只有脚踏实地的结果");
        map.put("processTime", new Date());


//        String s = ElasticsearchUtils.addData(JSONObject.parseObject(JSONObject.toJSONString(map)), "tan", "tan1", "id=" + 2);
        boolean tan = ElasticsearchUtils.isIndexExist("tan");
        System.out.println(tan);
        Map<String, Object> stringObjectMap = ElasticsearchUtils.searchDataById("tan", "tan1", "id=2", null);

        return JSONObject.toJSONString(stringObjectMap);
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
