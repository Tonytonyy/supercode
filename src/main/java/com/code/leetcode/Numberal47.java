package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Numberal47 {
    public static void main(String[] args){
        Numberal47 numberal47 = new Numberal47();
        int[] num = {1,1,2};
        numberal47.permuteUnique(num);
    }
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return result;
    }
    public void dfs(int[] nums, int index, List<Integer> numList){
        if (numList.size() == nums.length && !result.contains(numList)){
            result.add(numList);
            System.out.println(numList);
            return;
        }
        for (int i= index;i<nums.length;i++){
            List<Integer> list = new ArrayList<>(numList);
            list.add(nums[i]);
            dfs(nums, i+1, list);
        }
    }

}
