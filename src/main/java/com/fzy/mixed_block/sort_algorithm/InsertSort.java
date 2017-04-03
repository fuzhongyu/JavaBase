package com.fzy.mixed_block.sort_algorithm;


import org.junit.Test;

/**
 * 插入排序(从小到大)
 * Created by fuzhongyu on 2017/3/7.
 */
public class InsertSort extends Sort{

    @Test
    public void test() {

        int[] arr=new int[10];
        arr=fillValue(arr);
        insertSort(arr);
        printfArr(arr);

    }

    /**
     * 冒泡排序算法（从第一个开始和后面的挨个比较，将较大的值放后面，这样一次循环能将最大值放最后面）
     * @param arr  需要排序的数组
     * @return
     */
    public void insertSort(int[] arr){

        //外层循环表示从第二个数开始插入
        for(int i=1;i<arr.length;i++){
            //判断是否插入
            if(arr[i]<arr[i-1]){
                int insertPosition=0;
                //查找插入位置
                for(int j=0;j<i;j++){
                    if(arr[i]<arr[j]){
                        insertPosition=j;
                        break;
                    }
                }

                int temp=arr[i];
                for(int k=i;k>insertPosition;k--){
                    arr[k]=arr[k-1];
                }
                arr[insertPosition]=temp;
            }
        }

    }

}
