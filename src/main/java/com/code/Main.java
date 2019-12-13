/*
 * Main.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code;

import java.util.List;

/**
 * @author damai
 *
 */
public class Main {
    public static void main(String[] args){
        String a = new String("1");
        String b = new String("1");
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }

    public static boolean isNull(List list){
        return list.isEmpty();
    }
}
