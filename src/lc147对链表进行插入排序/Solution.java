package lc147对链表进行插入排序;

import common.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head.next;
        ListNode p;
        ListNode tail = head;
        while ( current != null ) {
            if (current.val > tail.val) {
                tail = current;
                current = current.next;
                continue;
            }
            p = dummy;
            while (p.next != tail && current.val > p.next.val){
                p = p.next;
            }
            ListNode temp = current.next;
            tail.next = temp;
            current.next = p.next;
            p.next = current;
            current = temp;
        }
        return dummy.next;
    }
}
