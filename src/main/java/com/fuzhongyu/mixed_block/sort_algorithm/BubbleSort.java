package com.fuzhongyu.mixed_block.sort_algorithm;


import org.junit.Test;

/**
 * 冒泡排序(从小到大)
 * Created by fuzhongyu on 2017/3/7.
 */
public class BubbleSort extends Sort{

    @Test
    public void test() {

        int[] arr=new int[10];
        arr=fillValue(arr);
        bubbleSort(arr);
        printfArr(arr);

    }

    /**
     * 冒泡排序算法（从第一个开始和后面的挨个比较，将较大的值放后面，这样一次循环能将最大值放最后面）
     * @param arr  需要排序的数组
     */
    public void bubbleSort(int[] arr){

        //外层循环表示需要比较的次数，如10个数每次把最大数放到最后，9轮能排好序
        for(int i=0;i<arr.length-1;i++){
            //内层循环，是两两比较，较大的数往后移
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

}
