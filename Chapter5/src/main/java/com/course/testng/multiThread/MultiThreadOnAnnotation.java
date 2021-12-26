package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * @author shengfulankuli
 * @create 2021-12-25 21:39
 */
public class MultiThreadOnAnnotation {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }


}
