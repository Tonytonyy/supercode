/*
 * Numeral20.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.leetcode;

import java.util.HashMap;

/**
 * @author damai
 *
 */
public class Numeral20 {
    /***
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        if (null == s){
            return false;
        }
        if (s.length() % 2==1){
            return false;
        }
        HashMap<Integer, Boolean> validMap = new HashMap <Integer, Boolean>(16);
        for (int i=0;i<s.length();i++){
            String s1 = String.valueOf(s.charAt(i));

            boolean go =  validMap.getOrDefault(i,false);
            if (!go){
                for (int j=i+1; j<s.length(); j++){
                    String s2 = String.valueOf(s.charAt(j));
                    if (s1.equals("(") && s2.equals(")")){
                        validMap.put(j, true);
                        break;
                    }else if (s1.equals("{") && s2.equals("}")){
                        validMap.put(j, true);
                        break;
                    }else if (s1.equals("[") && s2.equals("]")){
                        validMap.put(j, true);
                        break;
                    }else if (j==s.length()-1){
                        return false;
                    }

                }
            }
        }
        return true;

    }
    public boolean isValid2(String s) {
        if (null == s){
            return false;
        }
        if (s.length() % 2==1){
            return false;
        }
        for (int i=0;i<s.length();i+=2){
            String s1 = String.valueOf(s.charAt(i));
            String s2 = String.valueOf(s.charAt(i+1));
            if (s1.equals("(") && s2.equals(")")){
            }else if (s1.equals("{") && s2.equals("}")){
            }else if (s1.equals("[") && s2.equals("]")){
            }else {
                return false;
            }

        }
        return true;

    }
}
