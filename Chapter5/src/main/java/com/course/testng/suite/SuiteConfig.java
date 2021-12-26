package com.course.testng.suite;

import org.testng.annotations.*;

/**
 * 测试套件之前需要运行的方法
 * @author shengfulankuli
 * @create 2021-12-25 15:53
 */
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suite运行啦");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("after suite 运行啦");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}
