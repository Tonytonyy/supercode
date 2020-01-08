package com.code.otheralgorithm;

import com.google.common.collect.Lists;

import java.util.List;

public class FullSort {
    public static void main(String[] args) {
        FullSort fullSort = new FullSort();
        int[] nums = {1,2,3};
        fullSort.runFullSort(nums,Lists.newArrayList(), 0);
        fullSort.fullSort.stream().forEach(System.out::println);
    }
    List<List<Integer>> fullSort = Lists.newArrayList();
    public void runFullSort(int[] nums, List<Integer> list, int index){
        if (list.size() == nums.length){
            fullSort.add(list);
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!list.contains(nums[i])){
                List<Integer> integerList = Lists.newArrayList(list);
                integerList.add(nums[i]);
                runFullSort(nums, integerList, i +1);
            }
        }
    }
}
