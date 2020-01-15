/*
 * Animal.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.grammar;

/**
 * @author damai
 *
 */
public interface Animal {
    public String eat();
    default String look(){
        return "animal look";
    }
}
