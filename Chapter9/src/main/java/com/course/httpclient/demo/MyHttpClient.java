package com.course.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 1. 创建HttpClient对象。
 *
 * 2. 创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，
 * 创建HttpPost对象。
 *
 * 3. 如果需要发送请求参数，可调用HttpGet、HttpPost共同的setParams(HttpParams params)方法来添加请求参数；
 * 对于HttpPost对象而言，也可调用setEntity(HttpEntity entity)方法来设置请求参数。
 *
 * 4. 调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。
 *
 * 5. 调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；
 * 调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。
 * 程序可通过该对象获取服务器的响应内容。
 *
 * 6. 释放连接。无论执行方法是否成功，都必须释放连接
 * @author shengfulankuli
 * @create 2021-12-28 20:16
 */
public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        String result;
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpResponse response = client.execute(httpGet);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
