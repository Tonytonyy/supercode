package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author damai
 *
 */
public class Numeral22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList <String>();
        generateParenthesis2(list, "",0,0,n);
        return list;
    }

    public void generateParenthesis2(List<String> list,String ans,int left,
            int right, int n) {
        if (right > n || left > n || right > left){
            return;
        }
        if (right ==n && left == n){
            list.add(ans);
        }
        if (right < n || left < n){
            String ans1 = new String(ans);
            generateParenthesis2(list, ans1 +"(", left +1 ,right, n);
            generateParenthesis2(list, ans1 +")", left ,right+1, n);

        }
    }
}
