/*
 * Fiter.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.newfeatures;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * @author damai
 *
 */
public class Fiter {
    public static <T> List<T> filter(List <T> list, BooleanFunctionalInterface b){
        if (Objects.isNull(list)){
            return Lists.newArrayList();
        }
        List<T> result = Lists.newArrayList();
        for(int i=0; i<list.size(); i++){
            T t = list.get(i);
            if (b.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}
