/*
 * Numeral198.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damai
 *
 */
public class Numeral198 {

    public static void main(String[] args){
        int[] nums = {1,2,3};
        Numeral198 numeral198 = new Numeral198();

    }

    int maxMonney = 0;
    //198. 打家劫舍
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0){
            return maxMonney;
        }
        if (nums.length == 1){
            return nums[1];
        }
        for (int i=0; i<2; i++){
            robTraversal(nums, i+1, nums[i]);
        }
        return maxMonney;
    }

    public void robTraversal(int[] nums, int index, int sum){

        if (index >= nums.length-1){
            maxMonney = Math.max(sum, maxMonney);
            return;
        }else {
            //上次已经偷了一下，下次必须要隔一家偷
            int length = Math.min(nums.length, index +3);
            for (int i=index+1; i<length; i++){
                robTraversal(nums, i+1, sum + nums[i]);
            }
        }
    }

    public int standardAnswerRob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }


}
