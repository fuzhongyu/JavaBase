package com.fuzhongyu.mixed_block.sort_algorithm;


import org.junit.Test;

/**
 * 二分法插入排序(从小到大)
 * Created by fuzhongyu on 2017/3/7.
 */
public class BinaryInsertSort extends Sort{

    @Test
    public void test() {

        int[] arr=new int[10];
        arr=fillValue(arr);
        binaryInsertSort(arr);
        printfArr(arr);

    }

    /**
     *
     * @param arr  需要排序的数组
     */
    public void binaryInsertSort(int[] arr){

        for(int i=1;i<arr.length;i++){

            if(arr[i]<arr[i-1]){
                int temp=arr[i];

                int left=0;
                int right=i-1;
                int mid;

                //查找要插入的位置
                while (left<=right){
                    mid=(left+right)/2;

                   if(arr[i]>arr[mid]){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }

                //这边必须用left,因为相邻两数取mid会取到较小的一个
                for(int k=i;k>left;k--){
                    arr[k]=arr[k-1];
                }
                arr[left]=temp;
            }
        }

    }

}
