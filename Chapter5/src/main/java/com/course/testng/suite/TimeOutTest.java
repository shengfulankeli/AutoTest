package com.course.testng.suite;

import org.testng.annotations.Test;

/**
 * @author shengfulankuli
 * @create 2021-12-26 15:33
 */
public class TimeOutTest {
    @Test(timeOut = 3000)
    public void testSuccess(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(timeOut = 2000)
    public void testFailed(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
