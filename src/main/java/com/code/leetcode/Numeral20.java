/*
 * Numeral20.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Stack;
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
        HashMap<String, String> map = new HashMap<String, String>(16) {
            {
                put("(", ")");
                put("{", "}");
                put("[", "]");
            }
        };
        Stack<String> stringStack = new Stack <String>();
        for (int i=0,length=s.length(); i<length; i++){
            String s1 = String.valueOf(s.charAt(i));
            if (map.containsKey(s1)){
                stringStack.push(s1);
            }
            //获取value值
            if (map.containsValue(s1)){
                if (stringStack.empty()){
                    return false;
                }
                String s2 = stringStack.pop();
                if (!map.get(s2).equals(s1)){
                    return false;
                }
            }
        }
        return stringStack.empty();
    }

}
