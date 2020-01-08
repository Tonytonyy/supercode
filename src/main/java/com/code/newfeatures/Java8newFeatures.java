package com.code.newfeatures;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class Java8newFeatures {

    public static void main(String[] args) {

    }

    @Test
    public void runJava8FlaMap(){
        List<List<String>> listList = Lists.newArrayList();
        List<String> list1 = Lists.newLinkedList();
        List<String> list2 = Lists.newLinkedList();
        List<String> list3 = Lists.newLinkedList();
        list1.add("xiaoxian");
        list1.add("b");
        list1.add("c");
        list2.add("d");
        list2.add("f");
        list3.add("done");
        listList.add(list1);
        listList.add(list2);
        listList.add(list3);

        listList.stream().flatMap(lists -> lists.stream()).forEach(System.out::println);
    }


}
