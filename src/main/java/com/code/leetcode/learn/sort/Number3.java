package com.code.leetcode.learn.sort;

import java.util.ArrayList;
import java.util.List;

public class Number3 {
    /***
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1){
            return;
        }
        for (int j=0; j<k; j++){
            int lastVal1 = nums[0];
            int lastVal2 ;
            for (int i=1; i<nums.length; i++){
                lastVal2 = nums[i];
                nums[i] = lastVal1;
                lastVal1 = lastVal2;
            }
            nums[0] = lastVal1;
        }


    }

    public void rotateTree(int[] nums, int index, int k) {

    }

}
