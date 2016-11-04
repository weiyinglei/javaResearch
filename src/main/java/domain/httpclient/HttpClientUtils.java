/*
 * File Name: HttpClientUtils.java
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author    weiyinglei
 * @version   STOWZ V1.0.0, 2016年10月28日
 * @see       
 * @since     STOWZ V1.0.0
 */

public class HttpClientUtils {  
    /** 
     * 日志处理类 
     */  
    private static final Log logger = LogFactory.getLog(HttpClientUtils.class);  
  
    // 读取超时  
    private final static int SOCKET_TIMEOUT = 30000;  
    // 连接超时  
    private final static int CONNECTION_TIMEOUT = 30000;  
    // 每个HOST的最大连接数量(连接至目的主机的线程数)  
    private final static int MAX_CONN_PRE_HOST = 2;  
    // 连接池的最大连接数(相当于线程数)  
    private final static int MAX_CONN = 2;  
    // 连接池  
    private final static HttpConnectionManager httpConnectionManager;  
      
    private static HttpClient httpClient;  
  
    static {  
        httpConnectionManager = new MultiThreadedHttpConnectionManager();  
        HttpConnectionManagerParams params = httpConnectionManager.getParams();  
        params.setConnectionTimeout(CONNECTION_TIMEOUT);  
        params.setSoTimeout(SOCKET_TIMEOUT);  
        params.setDefaultMaxConnectionsPerHost(MAX_CONN_PRE_HOST);  
        params.setMaxTotalConnections(MAX_CONN);  
        httpClient = new HttpClient(httpConnectionManager);  
  
 }  
  
    /** 
     * 发送主要方法,异常捕获 
     *  
     * @param post 
     * @param code 
     * @return 
     */  
    public static String doHttpPostRequest(PostMethod post) {  
        String resultString = "";  
        try {  
            httpClient.executeMethod(post);  
            if (post.getStatusCode() == HttpStatus.SC_OK) {  
                resultString = post.getResponseBodyAsString(); 
            }
        } catch (HttpException e) {  
            logger.error("http请求超时", e);  
        } catch (IOException e) {  
            logger.error("IO超时", e);  
        } finally {  
            post.releaseConnection();  
        }  
        return resultString;  
    }  
  
    /** 
     * 设置一下返回错误的通用提示,可以自定义格式. 
     *  
     * @param reason 
     * @return 
     */  
    public static String returnError(String reason) {  
        StringBuffer buffer = new StringBuffer();  
        buffer.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");  
        buffer.append("<Response>");  
        buffer.append("<Success>false</Success>");  
        buffer.append("<reason>");  
        buffer.append(reason);  
        buffer.append("</reason>");  
        buffer.append("</Response>");  
        return buffer.toString();  
    }  
  
    public final static String REQUEST_HEADER = "x-forwarded-for";  
  
    /** 
     * 将客户IP写入请求头 这个设置可以伪装IP请求,注意使用 
     *  
     * @param client 
     * @param ip 
     * @return 
     */  
    public static void resetRequestHeader(HttpClient client, String ip) {  
        List<Header> headers = new ArrayList<Header>();  
        headers.add(new Header(REQUEST_HEADER, ip));  
        client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);  
    }  
} 
