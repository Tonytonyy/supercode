/*
 * Numeral18.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author damai
 *
 */
public class Numeral18 {
    /***
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        fourSumFullSort(nums, 0, target, new ArrayList<>(), 0);
        return result;

    }
    public void fourSumFullSort(int[] nums, int index, int target, List<Integer> integerList, int sum){
        if (integerList.size() == 4 && sum == target && !result.contains(integerList)){
            result.add(integerList);
            return;
        }
        if (integerList.size() < 4){
            for (int i=index; i<nums.length; i++){
                    List<Integer> list = new ArrayList<>();
                    list.addAll(integerList);
                    list.add(nums[i]);
                    fourSumFullSort(nums, i + 1, target, list, sum + nums[i]);
            }
        }


    }
    @Test
    public void test01(){
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> list = fourSum(nums, 0);
        System.out.println(String.valueOf(list));
        Assert.assertTrue(true);
    }
    @Test
    public void test02(){
        int[] nums = {-5,5,4,-3,0,0,4,-2};
        List<List<Integer>> list = fourSum(nums, 4);
        System.out.println(String.valueOf(list));
        Assert.assertTrue(true);
    }
}
