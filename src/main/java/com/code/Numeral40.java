package com.code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Numeral40 {
    public static void main(String[] args){
        int[] num = {10,1,2,7,6,1,5};
        Numeral40 numeral40 = new Numeral40();
        numeral40.combinationSum2(num, 8);
        Arrays.sort(num);
        System.out.println(numeral40.result);
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combination_Sum2(candidates, target, new ArrayList<>(),0,0);
        return result;
    }

    public void combination_Sum2(int[] candidates, int target, List<Integer> list, int sum, int index){
        if(sum == target ){
            Collections.sort(list);
            if (!result.contains(list)){
                result.add(list);
            }

            return;
        }else{
            for(int i=index;i<candidates.length;i++){
                if (candidates[i] !=0){
                    List<Integer> sumList = new ArrayList<>();
                    sumList.addAll(list);
                    sumList.add(candidates[i]);
                    combination_Sum2(candidates, target, sumList, sum+candidates[i],i+1);
                }

            }
        }
    }
}
