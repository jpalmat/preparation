package javaPrep.leetcode.easy;

public class MergedTwoSorted {
    public static void main(String[] args) {
        ListNode p41 = new ListNode(4);
        ListNode p21 = new ListNode(2, p41);
        ListNode p11 = new ListNode(1, p21);

        ListNode p42 = new ListNode(4);
        ListNode p31 = new ListNode(3, p42);
        ListNode p12 = new ListNode(1, p31);

        System.out.println(mergeTwoLists(p11, p12));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p=head;

        ListNode p1=l1;
        ListNode p2=l2;
        int i = 1;
        while(p1!=null && p2!=null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p=p.next;
        }

        if(p1!=null){
            p.next = p1;
        }

        if(p2!=null){
            p.next = p2;
        }

        return head.next;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}