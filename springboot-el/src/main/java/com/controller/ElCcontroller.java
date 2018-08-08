package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.utils.ElasticsearchUtils;
import com.utils.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2018/8/2
 * Time: 下午9:30
 */
@Controller
public class ElCcontroller {
    private final Log logger = LogFactory.getLog(getClass());
    private final static String index = "test";
    private final static String type = "tst";

    /**
     * 查询数据
     *
     * @param key
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public String testel(String key) {
        if (!ElasticsearchUtils.isIndexExist(index)) {
            try {
                ElasticsearchUtils.createIndex(index, type);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Map<String, Object>> list = ElasticsearchUtils.searchListData(index, type, 1024, "", "title=" + key);
        return JSONObject.toJSONString(list);
    }

    /**
     * to主页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 数据保存
     *
     * @return
     */
    @RequestMapping("/fileInsert")
    public String fileInsert() {
        String path = this.getClass().getResource("/1.txt").getPath();
        FileUtils.readFileByLines(path, index, type);
        return "success";
    }

    /**
     * 数据删除
     *
     * @return
     */
    @RequestMapping("/del")
    public String del() {
        boolean f = ElasticsearchUtils.deleteIndex(index);
        return JSONObject.toJSONString("success");
    }

    private static AtomicInteger count = new AtomicInteger(0);

    @ResponseBody
    @RequestMapping("/testinst")
    public String testinst(String title, String now_price, String old_price, String coupon, String summary, String
            sp_url) {
        Map<String, String> map = new HashMap<>(16);
        map.put("title", title);
        map.put("now_price", now_price);
        map.put("old_price", old_price);
        map.put("coupon", coupon);
        map.put("summary", summary);
        map.put("sp_url", sp_url);
        int i = count.addAndGet(1);
        logger.info("第 " + i + "条，数据为: " + map);
        String s = ElasticsearchUtils.addData(JSONObject.parseObject(JSONObject.toJSONString(map)), index,
                type,
                String.valueOf(i));
        logger.info("是否添加成功：" + s);
        return "success";
    }
}
