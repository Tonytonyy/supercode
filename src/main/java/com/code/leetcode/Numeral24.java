package com.code.leetcode;

import com.code.leetcode.node.ListNode;

/**
 * @author damai
 *
 */
public class Numeral24 {
    public ListNode swapPairs(ListNode head) {
        ListNode current = new ListNode(0);
        current.next = head;
        ListNode tmp = head;
        int lastVal = 0;
        while (tmp!=null){
            lastVal = tmp.val;
            ListNode last = tmp;
            tmp = tmp.next;
            if (tmp != null){
                last.val = tmp.val;
                tmp.val = lastVal;
                tmp = tmp.next;
            }

        }
        return current.next;

    }
}
