package com.code.leetcode.learn.sort;

import java.util.HashMap;

public class Number5 {
    /***
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     *
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     *
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     *
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums){
            int count =  map.getOrDefault(num, 0);
            count ++;
            map.put(num, count);
        }
        return map.entrySet().stream().filter(ent->ent.getValue().equals(2)).findFirst().get().getKey();
    }
    /***
     * 异或运算的特点：两个相同的数字异或，结果为0。
     *
     * 因为数组中除了一个元素只出现一次之外，其它的元素都出现两次，
     * 如果把所有的数都异或，相同的数字异或为0，最后只剩下出现一次的数字，它和0异或，结果就是它本身。
     */
    public int singleNumber2(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }

}
