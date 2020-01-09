package com.code.leetcode.learn.sort;

import java.util.Arrays;

public class Number1 {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */

       public int removeDuplicates(int[] nums) {
           if ( nums.length ==0){
               return 0;
           }
           int index = 1;
           int lastVal = nums[0];
           for (int i=1,length = nums.length; i<length;i++){
               int tmp = nums[i];
               if (tmp != lastVal){
                   nums[index] = tmp;
                   index ++;
                   lastVal = tmp;
               }
           }
           return index;
    }

    public void testRemoveDuplicates(){
           int[] arr = {1,2,2,3,3,4,5};
           removeDuplicates(arr);
           System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){
           new Number1().testRemoveDuplicates();
           System.out.println(1^1);
    }
}
