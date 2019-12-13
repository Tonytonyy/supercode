/*
 * Numeral55.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.leetcode;

/**
 * @author damai
 *
 */
public class Numeral55 {
    public boolean canJump(int[] nums) {
        return can_Jump(nums,0, nums[0]);
    }
    public boolean can_Jump(int[] nums, int currentIndex, int jump) {
        if (currentIndex + jump >= nums.length){
            return true;
        }
        if (jump==0){
            return false;
        }

        for (int i=currentIndex; i<=currentIndex+jump; i++){
            if (currentIndex + nums[i] >= nums.length || can_Jump(nums, currentIndex+nums[i],
                    nums[currentIndex+nums[i]])){
                return true;
            }
        }
        return false;
    }
}
