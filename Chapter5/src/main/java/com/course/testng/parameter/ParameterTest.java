package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author shengfulankuli
 * @create 2021-12-25 19:51
 */
public class ParameterTest {
    @Test
    @Parameters({"name","age"})
    public void paramTest(String name,int age){

        System.out.println("name="+name+",age="+age);
    }

}
