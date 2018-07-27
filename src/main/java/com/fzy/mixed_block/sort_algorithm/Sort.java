package com.fzy.mixed_block.sort_algorithm;

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
            arr[i]= (int) Math.round(Math.random()*arr.length*arr.length+1);
        }
        return arr;
    }


    public int[] fillNotSameValue(int[] arr){
        for (int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }

        for (int i=arr.length-1;i>=0;i--){
            int index=(int)Math.floor(Math.random()*i);
            int temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
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
