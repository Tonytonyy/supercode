package com.code.leetcode;

/**
 * @author damai
 *
 */
public class Numeral33 {
    /***
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int search(int[] nums, int target) {
        for (int i=0, lenght = nums.length; i<lenght;i++){
            if (nums[i]==target){
                return i;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int left = 0;
        int rignt = nums.length-1;

        while (left<=rignt){
            if (nums[left]==target){
                return left;
            }
            if (nums[rignt]==target){
                return rignt;
            }

            if (target>nums[left]){
                left++;
            }else {
                rignt --;
            }
        }
        return -1;
    }
}
