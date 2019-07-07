package com.code.leetcode;

import java.util.Arrays;

/**
 * @author damai
 *
 */
public class Numeral31 {
    /***
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须原地修改，只允许使用额外常数空间。
     *
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public void nextPermutation(int[] nums) {
        if (nums.length <=1){
            return;
        }
        int minNum = nums[nums.length-1];
        int index = nums.length-1;
        for (int i=nums.length-2; i>=0; i--){
            if (nums[i] < minNum){
                nums[index] = nums[i];
                nums[i] = minNum;
                //对 i+1 到end区域重新排序
                for (int j=i+1; j< nums.length-1; j++){
                    for (int k=j+1; k<nums.length;k++){
                        if (nums[j]>nums[k]){
                            int tmp = nums[j];
                            nums[j] = nums[k];
                            nums[k] = tmp;
                        }
                    }
                }
                return;
            }
        }
        Arrays.sort(nums);

    }
    //从后往前遍历，找到第一个下降的值nums[i]，和之后刚刚大于这个值的nums[j]交换位置。再对i之后的进行排序。
    public void nextPermutation2(int[] nums) {
        int temp;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if(nums[i] < nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}
