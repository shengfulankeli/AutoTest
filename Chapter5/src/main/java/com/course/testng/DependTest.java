package com.course.testng;


import org.testng.annotations.Test;

/**
 * @author shengfulankuli
 * @create 2021-12-25 19:15
 */
public class DependTest {
//    public static void main(String[] args) {
//        int[] arr1=new int[]{15,45,4,7,6,30,14,1};
//        for(int i=0;i<arr1.length;i++){
//            System.out.print(arr1[i]+" ");
//        }
//
//        for(int i=0;i<arr1.length-1;i++){
//            for(int j=0;j<arr1.length-i-1;j++){
//                if(arr1[j]>arr1[j+1]){
//                    int temp=arr1[j];
//                    arr1[j]=arr1[j+1];
//                    arr1[j+1]=temp;
//                }
//
//            }
//        }
//        System.out.println("");
//        for(int i=0;i<arr1.length;i++){
//            System.out.print(arr1[i]+" ");
//        }
//    }
    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }


}
