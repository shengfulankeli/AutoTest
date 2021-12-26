package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author shengfulankuli
 * @create 2021-12-25 18:48
 */
@Test(groups = "teacher")
public class GroupOnClass3 {
    public void teacher1(){
        System.out.println("GroupOnClass3中的teacher1运行");
    }
    public void teacher2(){
        System.out.println("GroupOnClass3中的teacher2运行");
    }
}
