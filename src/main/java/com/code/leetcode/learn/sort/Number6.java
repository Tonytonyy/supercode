package com.code.leetcode.learn.sort;

import java.util.*;

public class Number6 {
    public static void main(String[] args){
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        intersect(num1, num2);
    }


    /***
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     */

    public static int[] intersect(int[] nums1, int[] nums2) {
        List list = new ArrayList<>();
        List<Integer> result = new ArrayList();
        list.addAll(Arrays.asList(nums1));
        for (int num:nums2){
            System.out.println(num);
            if (list.contains(num)){
                result.add(num);
                list.remove(num);
            }
        }
        result.stream().forEach(System.out::println);
        int[] ans = new int[result.size()];
        result.stream().forEach(num -> {
            ans[result.indexOf(num)] = num.intValue();
        });
        return ans;
    }
}
