/*
 * Numeral139.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author damai
 *
 */
public class Numeral139 {

    public static void main(String[] args){
        List<String> list = Lists.newArrayList("apple","pen");
        Numeral139 numeral198 = new Numeral139();
        System.out.println(numeral198.wordBreak("applepenapple",  list));
    }

    private boolean contains  = false;
    public boolean wordBreak(String s, List <String> wordDict) {
        wordBreakTraversal(s,wordDict,0);
        return contains;
    }

    public void wordBreakTraversal(String s, List <String> wordDict, int wordDictIndex){
        //判断是否结束
        if (s.isEmpty()){
            contains = true;
            return;
        }
        if (!contains){
            for (int i=0; i<wordDict.size(); i++){
                if (s.indexOf(wordDict.get(i)) ==0){
                    wordBreakTraversal(s.replaceFirst(wordDict.get(i),""), wordDict,
                            wordDictIndex+1 );
                }
            }
        }
    }
}
