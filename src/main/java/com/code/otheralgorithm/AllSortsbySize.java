/*
 * AllSortsbySize.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.otheralgorithm;

import java.util.Arrays;

public class AllSortsbySize {
    public static void main(String[] args){
        System.out.println("122334");
        new AllSortsbySize().testQuickSort();
    }
    public void testQuickSort(){
        int[] arr = {3,1,4,5,2};
        quickSort(arr,0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right){
        if (left >= right ){
            return;
        }
        int low = left;
        int hight = right;
        int tmp = arr[low];
        while (low < hight){

            while (low < hight && arr[hight] >=tmp){
                hight --;
            }
            while (low<hight && arr[low] <= tmp ){
                low ++;
            }
            if (low < hight){
                int val = arr[low];
                arr[low] = arr[hight];
                arr[hight] = val;
            }


        }

        arr[left] = arr[low];
        arr[low] = tmp;

        quickSort(arr,left, low-1);
        quickSort(arr,low+1, right);
    }
    public void bunnleSort(int[] arr){
    }
}
