/*
 * BooleanFunctionalInterfaceTest.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.newfeatures;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
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
    public void fiterTest(){
        List<String> result = Fiter.filter(list, str -> StringUtils.equals((String)str,
                "xiaoming"));
        result.stream().forEach(System.out::println);
    }
}
