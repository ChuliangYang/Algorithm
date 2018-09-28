package com.me.cl.java.linkedlist;

/**
 * 141.
 * Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow=head;
        ListNode fast=head;
        while(true){
            if(fast.next==null) return false;
            slow=slow.next;
            fast=fast.next.next;
            if(fast==null){
                return false;
            }else if(fast==slow){
                return true;
            }
        }
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
