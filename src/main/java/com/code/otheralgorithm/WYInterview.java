package com.code.otheralgorithm;

import com.code.leetcode.node.ListNode;
import com.google.common.collect.Lists;
import org.junit.Test;
import java.util.List;

public class WYInterview {
    /**
     * 输入字符串，求全排序
     */
    public List<String> fullSort(String string){
        List<String> fullSortList = Lists.newArrayList();
        reFullSort(string, "",fullSortList, 0);
        fullSortList.stream().forEach(System.out::println);
        return fullSortList;
    }
    public void reFullSort(String string, String tmp, List<String> fullSortList, int index){
        if (string.length() == tmp.length()){
            fullSortList.add(tmp);
            return;
        }
        for (int i=0; i<string.length(); i++){
            if (!tmp.contains(String.valueOf(string.charAt(i)))){
                String s = tmp + string.charAt(i);
                reFullSort(string, s, fullSortList, i);
            }
        }
    }
    @Test
    public void testFullSort(){
        fullSort("abcd");
    }

    /***
     *2、链表反转
     */
    public ListNode listNodeReverse(ListNode node){
        ListNode currentNode = node;
        ListNode perNode = null;
        ListNode nextNode = null;
        while (null!=currentNode){
            nextNode = currentNode.next;
            currentNode.next = perNode;
            perNode = currentNode;
            currentNode = nextNode;

        }
        return perNode;
    }
    @Test
    public void testListNodeReverse(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode reverseNode = listNodeReverse(listNode1);
        while (null != reverseNode){
            System.out.println(reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }

}
