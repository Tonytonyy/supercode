/*
 * Main.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.grammar;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author damai
 *
 */
public class Main {
    @Test
    public void animalTest(){
        String s = "";
        Animal animal = new Dog();
        System.out.println(animal.look());
    }
}
