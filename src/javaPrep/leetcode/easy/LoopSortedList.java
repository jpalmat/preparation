package javaPrep.leetcode.easy;

public class LoopSortedList {

    public static void main(String[] args) {
        ListNode two = new ListNode(2, null);
        ListNode one = new ListNode(1, two);
        ListNode head = new ListNode(1, one);

        goThroughtSortedList(head);
    }

        public static void goThroughtSortedList(ListNode head) {
            if(head==null || head.next==null) System.out.println("empty");;

            ListNode actual = head;

            while(actual!= null) {
                System.out.println(actual.val);
                actual = actual.next;
            }
            System.out.println(head.val);
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
