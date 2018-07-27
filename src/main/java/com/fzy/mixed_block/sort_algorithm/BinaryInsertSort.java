package com.fzy.mixed_block.sort_algorithm;


import org.junit.Test;

/**
 * 二分法插入排序(从小到大)
 * 时间复杂度： O(nlogn)
 * Created by fuzhongyu on 2017/3/7.
 */
public class BinaryInsertSort extends Sort{

    @Test
    public void test() {

        int[] arr=new int[10];
        arr=fillValue(arr);
//        binaryInsertSort(arr);
        binaryInsertSortRec(arr);
        printfArr(arr);

    }

    /**
     *
     * @param arr  需要排序的数组(非递归)
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
                    }else if (arr[i]<arr[mid]){
                        right=mid-1;
                    }else {
                       left=mid;
                       break;
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



    /**
     *
     * @param arr  需要排序的数组(递归方法)
     */
    public void binaryInsertSortRec(int[] arr){
        for (int i=1;i<arr.length;i++){
            if (arr[i]>=arr[i-1]){
                continue;
            }

            int index=getIndex(arr,0,i-1,arr[i]);

            int temp=arr[i];
            for (int k=i;k>index;k--){
                arr[k]=arr[k-1];
            }
            arr[index]=temp;
        }

    }

    public int getIndex(int[] arr,int prefix,int suffix,int node){
        int range=suffix-prefix;
        if (range>=0){
            int mid=(prefix+suffix)/2;
            if (node>arr[mid]){
                return getIndex(arr,mid+1,suffix,node);
            }else if (node<arr[mid]){
                return getIndex(arr,prefix,mid-1,node);
            }else {
                return mid;
            }
        }else {
            return prefix;
        }
    }

}
