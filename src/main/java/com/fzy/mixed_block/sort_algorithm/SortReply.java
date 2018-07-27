package com.fzy.mixed_block.sort_algorithm;

import org.junit.Test;

/**
 * @author Fucai
 * @date 2018/5/26
 */

public class SortReply extends Sort {

  @Test
  public void test() {

    int[] arr=new int[10];
    arr=fillValue(arr);
    sort(arr,0,arr.length-1);
    printfArr(arr);

  }

  public void sort(int[] arr,int left,int right){

    if (left>=right){
      return;
    }

    int temp=arr[left];

    int i=left,j=right;

    while (left<right){
      while (arr[right]>=temp && left<right){
        right--;
      }
      if (left<right){
        arr[left++]=arr[right];
      }

      while (arr[left]<=temp && left<right){
        left++;
      }
      if (left<right){
        arr[right--]=arr[left];
      }
    }
    arr[left]=temp;

    sort(arr,i,left-1);
    sort(arr,left+1,j);
  }




}
