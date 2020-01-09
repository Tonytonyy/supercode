/*
 * FindMax.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.otheralgorithm;


/**
 * @author damai
 *
 */
public class FindMax {

    public static void main(String[] args){
        new FindMax().testFindMax();
    }
    public void testFindMax(){
        int[] arr = {1,2,3,4,6,8,10};
        findMax(arr);
    }
    public void findMax(int[] arr){
        int mix = Integer.MIN_VALUE;
        int secedMax = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (arr[i] >= mix){
                secedMax = mix;
                mix = arr[i];
            }
        }
        System.out.println(mix);
        System.out.println(secedMax);
    }
}
