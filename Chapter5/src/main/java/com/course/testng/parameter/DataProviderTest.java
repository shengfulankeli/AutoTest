package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author shengfulankuli
 * @create 2021-12-25 20:22
 */
public class DataProviderTest {
    @Test(dataProvider = "Data")
    public void testDataProvider(String name,int age){
        System.out.println("name ="+name+",age="+age);
    }
    @DataProvider(name="Data")
    public Object[][] providerData(){
        Object[][] arr=new Object[][] {
                {"zhangsan",10},
                {"lisi",20},
                {"wanwu",30}
        };
        return arr;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1方法 name="+name+",age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2方法 name="+name+",age="+age);
    }

    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] arr=null;
        if("test1".equals(method.getName())){
                arr=new Object[][]{
                        {"zhangsan",20},
                        {"lisi",25}
                };
        }else if("test2".equals(method.getName())){
            arr=new Object[][]{
                    {"wangwu",50},
                    {"zhaoliu",60}
            };
        }
        return arr;
    }
}
