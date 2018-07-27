package com.fzy.mixed_block.sort_algorithm;

import org.junit.Test;

/**
 * 快速排序(从小到大)
 * 时间复杂度: O(nlog(n))
 * Created by fuzhongyu on 2017/3/7.
 */
public class QuickSort extends Sort{

    @Test
    public void test() {

        int[] arr=new int[10];
        arr=fillValue(arr);
        quickSort(arr,0,arr.length-1);
        printfArr(arr);

    }

    /**
     * @param arr  需要排序的数组
     * @param left 左边
     * @param right 右边
     * @return
     */
    public void quickSort(int[] arr,int left,int right){

        if(left>=right){
            return;
        }

        int i=left,j=right;

        int baseCount=arr[left];

        while (i<j){
            while (i<j&&arr[j]>=baseCount){
                j--;
            }
            if(i<j){
                arr[i++]=arr[j];  //即分为arr[i]=arr[j];i+=1;两步
            }

            while (i<j&&arr[i]<=baseCount){
                i++;
            }
            if(i<j){
                arr[j--]=arr[i]; //即分为arr[j]=arr[i];j-=1;两步
            }
        }

        arr[i]=baseCount;

        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);

    }

}
