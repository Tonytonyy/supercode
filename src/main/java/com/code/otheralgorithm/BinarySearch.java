/*
 * BinarySearch.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.otheralgorithm;

public class BinarySearch {
    public static void main(String[] args){
        new BinarySearch().testNonmarBinarySearch();
    }
    public void testNonmarBinarySearch(){
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(reBinarySearch(arr,0, arr.length -1, 3));
    }
    public void testReBinarySearch(){
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(reBinarySearch(arr,0, arr.length -1, 6));

    }
    public int reBinarySearch(int[] arr, int left, int right, int target){
        if (left > right || arr[right] < target || arr[left] > target){
            return -1;
        }
        int mid =  left  + (right -left)/2;
        if (arr[mid] > target){
            return  reBinarySearch(arr,left,mid-1,target);
        }else if (arr[mid] < target){
            return reBinarySearch(arr, mid + 1, right, target);
        }else {
            return mid;
        }
    }
    public int nonmarBinarySearch(int[] arr, int left, int right, int target){
        if (left > right || arr[right] < target || arr[left] > target){
            return -1;
        }
        int mid =  left  + (right -left)/2;

        while (left < right){
            if (arr[mid] == target){
                return mid;
            }
            while (left < right && arr[mid] < target){
                left = mid + 1;
                mid =  left  + (right -left)/2;
            }
            while (left < right && arr[mid] > target){
                right = mid - 1;
                mid =  left  + (right -left)/2;
            }
        }
        return -1;

    }
}
