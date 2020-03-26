/*
 * BooleanFunctionalInterfaceTest.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.newfeatures;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * @author damai
 *
 */
public class BooleanFunctionalInterfaceTest {

    private List<String> list = Lists.newArrayList();
    @Before
    public void fiterTestBefore(){
        list.add("xiaoming");
        list.add("xiaohong");
        list.add("xiaogang");
    }

    @Test
    @Ignore
    public void fiterTest(){
        List<String> result = Fiter.filter(list, str -> StringUtils.equals((String)str,
                "xiaoming"));
        result.stream().forEach(System.out::println);
    }
    @Test
    public void test2(){
        Object target1 = (Runnable)() -> System.out.println("新建了一个线程");
        new Thread((Runnable) target1).start();
        new Thread(()-> System.out.println("新增线程2")).start();;
    }
}
