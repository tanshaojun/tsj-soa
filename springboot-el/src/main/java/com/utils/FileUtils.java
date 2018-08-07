package com.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FileUtils {


    public static void readFileByLines(String fileName, String index, String type) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                Map map1 = JSONObject.parseObject(tempString, Map.class);
                String s = ElasticsearchUtils.addData(JSONObject.parseObject(JSONObject.toJSONString(map1)), index,
                        type,
                        String.valueOf(line));
                System.out.println("line " + line + ": " + tempString + ":s" + s);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
