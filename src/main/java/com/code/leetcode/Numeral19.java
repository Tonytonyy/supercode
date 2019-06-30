/*
 * Numeral19.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.code.leetcode;

import com.code.leetcode.node.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qingliang
 *
 */
public class Numeral19 {
    /***
     *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     */

     //解法1
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head;
        ListNode result = new ListNode(0);
        List<Integer> list = new ArrayList <>();
        if (null==head){
            return head;
        }
        while (null!=currentNode){
            list.add(currentNode.val);
            currentNode = currentNode.next;

        }
        list.remove(list.size() -n);

        ListNode result2 = result;
        for (int num:list){
            ListNode listNode = new ListNode(num);
            result.next = listNode;
            result = listNode;
        }
        return result2.next;
    }
    //算法2
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp = head;
        Map<Integer,ListNode> m = new HashMap<Integer,ListNode>();
        int index=1;
        while(temp!=null){
            m.put(index++,temp);
            temp = temp.next;
        }
        int size = m.size();
        if(size == 1)
            return null;
        if(n == 1){
            m.get(size-1).next = null;
        }else if(n == size){
            head = head.next;
        }else{
            m.get(size-n).next = m.get(size-n+2);
        }
        return head;
    }

}
