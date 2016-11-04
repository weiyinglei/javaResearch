/*
 * File Name: HttpClientTest.java
 * Copyright: Copyright 2012-2016 CETC52 CETITI All Rights Reserved.

 * Description: 
 * Author: weiyinglei
 * Create Date: 2016年10月28日

 * Modifier: weiyinglei
 * Modify Date: 2016年10月28日
 * Bugzilla Id: 
 * Modify Content: 
 */
package domain.httpclient;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author weiyinglei
 * @version STOWZ V1.0.0, 2016年10月28日
 * @see
 * @since STOWZ V1.0.0
 */

public class HttpClientTest
{

    /**
     * 组装参数,这里用Map,一键一值比较通用,可以当做共用方法
     * 
     * @param params
     * @return
     */
    private NameValuePair[] buildNameValuePairs(Map<String, String> params)
    {
        Object[] keys = params.keySet().toArray();
        NameValuePair[] pairs = new NameValuePair[keys.length];

        for (int i = 0; i < keys.length; i++)
        {
            String key = (String) keys[i];
            pairs[i] = new NameValuePair(key, params.get(key));
        }

        return pairs;
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的HTML
     * 
     * @param url
     *            请求的URL地址
     * @param params
     *            请求的查询参数,可以为null
     * @return 返回请求响应的string
     * @throws UnsupportedEncodingException 
     */
    public String doPost(String url, String json, Map<String, String> params) throws UnsupportedEncodingException
    {
        String response = "";
        /*
         * if (null == url || "".equals(url.trim())) { return
         * HttpClientUtil.returnError("推送地址错误[url=" + url + "]"); } if (null ==
         * code || "".equals(code.trim())) { return
         * HttpClientUtil.returnError("编码错误[code=" + code + "]"); }
         * 
         * if (null == params || params.size() == 0) { return
         * HttpClientUtil.returnError("无传递参数[params.size = 0]"); }
         */
        PostMethod postMethod = new PostMethod(url);
        
        postMethod.addRequestHeader("Content-type","application/json; charset=utf-8");
        postMethod.addRequestHeader("Accept", "application/json");
        postMethod.setRequestEntity(new StringRequestEntity(json,"application/json","UTF-8"));
        
//        postMethod.addHeader("Content-type","application/json; charset=utf-8");
//        postMethod.setHeader("Accept", "application/json");
//        postMethod.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
        
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        // 设置失败重复提交次数
        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
            new DefaultHttpMethodRetryHandler(5, true));

//        postMethod.setRequestBody(buildNameValuePairs(params));
        response = HttpClientUtils.doHttpPostRequest(postMethod);
        return response;
    }

    public static void main(String[] args) throws UnsupportedEncodingException
    {
//        String url = "http://localhost/serlvet";
//        String xml = "xxxxxxxxxxxxxxxxxxxxxxx";
        String url = "http://122.225.51.173:23005/GetAllParkingList";
        String xml = "xxxxxxxxxxxxxxxxxxxxxxx";
        HashMap<String, String> params = new HashMap<String, String>();
//        params.put("aaaa", xml);
        String json = "{\"version\":\"V1.0\"}";
        String r = new HttpClientTest().doPost(url, json, params);
        System.out.println(r);
    }
    
    public static void main2(String[] args) throws UnsupportedEncodingException
    {
//        String url = "http://localhost/serlvet";
//        String xml = "xxxxxxxxxxxxxxxxxxxxxxx";
        String url = "http://122.225.51.173:23005/GetParkingInfo";
        String xml = "xxxxxxxxxxxxxxxxxxxxxxx";
        HashMap<String, String> params = new HashMap<String, String>();
//        params.put("aaaa", xml);
//        "data":[{"parkingCode":"161019021957043570","parkingName":"涔岄晣浜掕仈缃戝尰闄?}],"errorCode":300000,"message":"success","sessionId":"宕?#鑰曡拝瀛縰0011\\鍒搕?.鍒竆u0011X","totalNum":1
        String json = "{\"version\":\"V1.0\",\"totalNum\":1,\"data\":[{\"parkingCode\":\"161019021957043570\"}]}";
        System.out.println(json);
        String r = new HttpClientTest().doPost(url, json, params);
        System.out.println(r);
        System.out.println(new String(r.getBytes("gbk"),"utf8"));
    }

}
