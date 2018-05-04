package com.tsj.common.utils;


public class AssembleErrJsonUtil {


    /**
     * @param err
     * @param success_register_callback
     * @param appendData
     * @return String    返回类型
     * @throws
     * @description 装配错误信息成JSON格式，支持JSONP, 并带有附加的信息，附加的信息在adata中
     * @author 赵以宝
     * @date 2016年7月15日 下午2:55:16
     */
    public static String AssembleErr2Json(ErrorEnum err, String success_register_callback, JSONObject appendData) {
        String jsonString = "";
        try {
            JSONObject json = new JSONObject();
            json.put("ecode", err.getErrorCode());
            json.put("emsg", err.getErrorMessage());
            if (appendData != null) {
                json.put("adata", appendData);
            }

            if (!StringUtils.isBlank(success_register_callback)) {
                jsonString = success_register_callback + "(";
            }

            jsonString += json.toString();

            if (!StringUtils.isBlank(success_register_callback)) {
                jsonString += ")";
            }
        } catch (Exception e) {
            // TODO: 封装jsonError异常
            e.printStackTrace();
        }
        return jsonString;
    }


    /**
     * @param @param  err
     * @param @param  success_register_callback
     * @param @return
     * @return String    返回类型
     * @throws
     * @description 装配错误信息成JSON格式
     * @author 赵以宝
     * @date 2015年12月8日 下午5:54:39
     */
    public static String AssembleErr2Json(ErrorEnum err, String success_register_callback) {
        return AssembleErr2Json(err, success_register_callback, (JSONObject) null);
    }

    /**
     * @param err
     * @param success_register_callback
     * @param referer
     * @return String    返回类型
     * @throws
     * @description 装配错误信息成JSON格式, 返回referer
     * @author 赵以宝
     * @date 2016年7月15日 下午3:31:20
     */
    public static String AssembleErr2Json(ErrorEnum err, String success_register_callback, String referer) {
        JSONObject json = new JSONObject();
        json.put("referer", referer);
        return AssembleErr2Json(err, success_register_callback, json);
    }

    /**
     * @param err
     * @param appendData
     * @return String    返回类型
     * @throws
     * @description 装配错误信息成JSON格式
     * @author 赵以宝
     * @date 2016年7月15日 下午3:01:16
     */
    public static String AssembleErr2Json(ErrorEnum err, JSONObject appendData) {
        return AssembleErr2Json(err, null, appendData);
    }


    /**
     * @param err
     * @return String    返回类型
     * @throws
     * @description 给客户端返回错误信息
     * @author 赵以宝
     * @date 2016年7月15日 下午3:01:33
     */
    public static String AssembleErr2Json(ErrorEnum err) {
        return AssembleErr2Json(err, (String) null, (JSONObject) null);
    }


    /**
     * @param restCode
     * @return JSONObject    返回类型
     * @throws
     * @description 用ErrorEnum创建一个给客户端返回信息的JSONObject
     * @author 赵以宝
     * @date 2016年7月15日 下午3:01:33
     */
    public static JSONObject assembleJSON(ErrorEnum restCode) {
        JSONObject object = new JSONObject();
        object.put("ecode", restCode.getErrorCode());
        object.put("emsg", restCode.getErrorMessage());
        return object;
    }

    /**
     * @param restCode
     * @return JSONObject    返回类型
     * @throws
     * @description 创建一个给客户端成功的返回信息的JSONObject
     * @author 赵以宝
     * @date 2016年7月15日 下午3:01:33
     */
    public static JSONObject assembleSuccessJSON() {
        JSONObject object = new JSONObject();
        object.put("ecode", ErrorEnum.ERR_COMMON_SUCCESS.getErrorCode());
        object.put("emsg", ErrorEnum.ERR_COMMON_SUCCESS.getErrorMessage());
        return object;
    }

    /**
     * @param msg
     * @param response
     * @return void    返回类型
     * @throws
     * @description 往response写一个JSON
     * @author 赵以宝
     * @date 2016年7月15日 下午2:47:12
     */
    public static void writerJson2Response(HttpServletResponse response, JSONObject json) {
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json.toString());
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param msg
     * @param response
     * @return void    返回类型
     * @throws
     * @description 往response写一个json string
     * @author 赵以宝
     * @date 2016年7月15日 下午2:47:12
     */
    public static void writerJson2Response(HttpServletResponse response, String json) {
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param err
     * @param result
     * @return String    返回类型
     * @throws
     * @description 装配错误信息成JSON格式
     * @author 赵以宝
     * @date 2018年1月23日 下午5:18:16
     */
    public static String AssembleErr2JsonJsonArrayResult(ErrorEnum err, Object result) {
        String jsonString = "";
        try {
            JSONObject json = new JSONObject();
            json.put("ecode", err.getErrorCode());
            json.put("emsg", err.getErrorMessage());
            if (result != null) {
                json.put("result", JSONArray.parseArray(JSONArray.toJSONString(result)));
            }
            jsonString += json.toString();
        } catch (Exception e) {
            // TODO: 封装jsonError异常
            e.printStackTrace();
        }
        return jsonString;
    }
}
