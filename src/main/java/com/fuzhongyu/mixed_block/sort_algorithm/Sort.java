package com.fuzhongyu.mixed_block.sort_algorithm;

import java.util.Arrays;

/**
 * 排序基类(公用方法)
 * Created by fuzhongyu on 2017/3/7.
 */
public class Sort {

    /**
     * 数组赋值
     * @param arr
     */
    public int[] fillValue(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]= (int) Math.round(Math.random()*10+1);
        }
        return arr;
    }

    /**
     * 输出数组
     * @param arr
     */
    public void printfArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
