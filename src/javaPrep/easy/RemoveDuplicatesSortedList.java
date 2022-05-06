package javaPrep.easy;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesSortedList {

    public static void main(String[] args) {
//        List test = new ArrayList();
//        test.add(5);
//
//        List testb = test;
//        testb.add(6);
//
//        System.out.println(test);
//        System.out.println(testb);

        ListNode two = new ListNode(2, null);
        ListNode one = new ListNode(1, two);
        ListNode head = new ListNode(1, one);

        System.out.println(deleteDuplicates(head));
    }

        public static ListNode deleteDuplicates(ListNode head) {
            if(head==null || head.next==null) return head;

            ListNode prev = head;
            ListNode curr=head.next;

            while(curr!=null) {
                if(prev.val == curr.val) {
                    curr=curr.next;
                }
                else {
                    prev.next=curr;
                    prev=curr;
                    curr=prev.next;
                }
            }
            prev.next=null;
            return head;
        }

    /**
     * Definition for singly-linked list.
     *
     */
    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
