package com.code.leetcode.learn.sort;

public class Number2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i=0;i<prices.length-1;i++){
            int j = i+1;
            int temp = prices[j] - prices[i];
            if (temp > 0){
                res += temp;
            }
        }
        return res;
    }
}
