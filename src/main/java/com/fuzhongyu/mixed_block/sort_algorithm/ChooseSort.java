package com.fuzhongyu.mixed_block.sort_algorithm;


import org.junit.Test;

/**
 * 选择排序（从小到大）
 * Created by fuzhongyu on 2017/3/7.
 */
public class ChooseSort extends Sort{

    @Test
    public void test() {

        int[] arr=new int[10];
        arr=fillValue(arr);
        chooseSort(arr);
        printfArr(arr);

    }

    /**
     * 选择排序算法（第一轮找出最小值，直接把着该值和第一个数交换，以此类推）
     * @param arr  需要排序的数组
     * @return
     */
    public void chooseSort(int[] arr){

        //外层循环表示需要比较的次数，如10个数每次把最小数放到最前，9轮能排好序
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int minIndex=i;
            //内层循环找出最小值，并记录其位置，和当前最小值
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            }

            //如果不在同一个位置则交换
            if(i!=minIndex){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }

        }
    }
}
