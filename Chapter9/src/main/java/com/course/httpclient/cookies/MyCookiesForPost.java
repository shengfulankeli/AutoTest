package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author shengfulankuli
 * @create 2021-12-29 13:54
 */
public class MyCookiesForPost {
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
        result= EntityUtils.toString(response.getEntity(),"utf-8");
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
    public void testPostMethod() throws IOException {
        String uri=bundle.getString("test.post.with.cookies");
        String testUrl=this.url+uri;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(testUrl);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        System.out.println(param);
        //设置请求头信息   设置header
        post.setHeader("content-type", "application/json");
        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookies信息
        client.setCookieStore(store);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(response.getEntity());
        //将返回的响应结果字符串转化为json对象
        JSONObject resultJson = new JSONObject(result);
        //获取到结果值
        String succss=(String) resultJson.get("huhansan");
        String status=(String) resultJson.get("status");
        //具体的判断返回结果的值
        Assert.assertEquals("success", succss);
        Assert.assertEquals("1", status);

    }
}
