package com.code.otheralgorithm;

import com.google.common.collect.Maps;
import com.sun.istack.internal.NotNull;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class AlibbInterview {
    /**
     * 1.回文判断
     */
    public boolean isHuiWen(char[] arr){
        if (Objects.isNull(arr) || arr.length == 0){
            return false;
        }
        int index =0;
        for (int i=0,length=arr.length/2;i<length;i++){
            if (!(arr[i] == arr[arr.length -1 -i])){
                return false;
            }
        }
        return true;
    }
    @Test
    public void testIsHunWen(){
        System.out.println(isHuiWen("12".toCharArray()));
    }
    /**
     * 2.二分查找，递归与正常查询
     */
    public int reBinarySearch(int[] arr, int left, int right, int target){
        if (left>right || arr[left] > target || arr[right] < target){
            return -1;
        }
        int mid = left + (right - left) /2;
        if (arr[mid] > target){
            return reBinarySearch(arr, left, mid -1, target);
        }else if (arr[mid] <  target){
            return reBinarySearch(arr, mid + 1, right, target);
        }else {
            return mid;
        }
    }

    public int normalBinarySearch(int[] arr, int target){
        int left = 0, right = arr.length-1;
        if (arr[left]>target || arr[right] < target){
            return -1;
        }
        while (left <= right){
            int mid = left + (right - left) /2;
            if (target > arr[mid]){
                left = mid +1;
            }else if (target < arr[mid]){
                right = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    @Ignore
    public void testReBinarySearch(){
        int[] arr = {1,2,3,4,5,6};
        System.out.println(reBinarySearch(arr,0,arr.length-1, 6));
        System.out.println(reBinarySearch(null,0,arr.length-1, 6));

    }
    @Test
    public void testNormalBinarySearch(){
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(normalBinarySearch(arr, 1));
        System.out.println(normalBinarySearch(arr, 2));
        System.out.println(normalBinarySearch(arr, 7));

    }
    /**
     * 3.for 循环找最大跟第二大数值
     */
    public int[] findMaxandSeacord(int[] arr){
        int[] reslut = new int[2];
        if (Objects.isNull(arr) || arr.length < 2){
            return reslut;
        }
        for (int i=0;i<arr.length; i++){
            if (arr[i] > reslut[0]){
                reslut[1] = reslut[0];
                reslut[0] = arr[i];
            }
        }
        return reslut;
    }
    @Test
    public void testFindMaxandSeacord(){
        int[] arr = {1,2,3,4,5,6,8};
        System.out.println(Arrays.toString(findMaxandSeacord(arr)));
    }
    /**
     * 4.输入字符串，统计次数
     */
    public Map<Character, Integer> srtCount(String str){
        Map<Character, Integer> map = Maps.newHashMap();
        if (Objects.isNull(str)){
            return map;
        }
        for (char c:str.toCharArray()){
            int count = map.getOrDefault(c,0);
            count ++;
            map.put(c, count);
        }
        map.entrySet().forEach(enrty -> System.out.println(enrty.getKey() + ":" + enrty.getValue()));
        return map;
    }
    @Test
    public void testSrtCount(){
        srtCount("aaasssndfdkjsbnfjkdsbfskjd");
    }
    /**
     * 数组排序，偶数在前 奇数在后
     */
    public void sortByParity(int[] arr){
        if (Objects.isNull(arr)){
            return;
        }
        int left = 0;
        int right = arr.length -1;
        while (left<=right){
            while (arr[right] % 2 == 0){
                right--;
            }
            while (arr[left] %2 != 0){
                left ++;
            }
            if (left <= right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
    }
    @Test
    public void testSortByParity(){
        int[] arr = {1,2,4,6,3,5,9};
        sortByParity(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 背包算法，
     */



}
