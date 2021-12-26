package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author shengfulankuli
 * @create 2021-12-25 18:47
 */
@Test(groups = "stu")
public class GroupOnClass2 {
    public void stu1(){
        System.out.println("GroupOnClass2中的stu1运行");
    }
    public void stu2(){
        System.out.println("GroupOnClass2中的stu2运行");
    }
}
