package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author shengfulankuli
 * @create 2021-12-28 21:15
 */
public class MyCookiesForGet {
    private String url;
//    利用ResourceBundle读取配置文件application.properties
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        // 从配置文件中 拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;
        // 测试逻辑代码书写
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookies信息
        this.store=client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie : cookieList){
            String name=cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name="+name+",cookie value="+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies () throws IOException {
        String uri=bundle.getString("test.get.with.cookies");
        String testUrl=this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        //设置cookies信息
        httpClient.setCookieStore(this.store);

        //发送请求
        HttpResponse response = httpClient.execute(get);

        //获取响应的状态码以及返回的内容
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if(statusCode==200){
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }
    }
}
