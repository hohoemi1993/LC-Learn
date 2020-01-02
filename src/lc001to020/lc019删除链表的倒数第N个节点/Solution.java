package lc001to020.lc019删除链表的倒数第N个节点;

/**
 * Created on 2019/2/20<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) return head;
        if (null == head.next) return null;

        ListNode p = head;
        int c = 0;
        while (null != p.next) {
            p = p.next;
            ++c;
        }
        if (c == n - 1) return head.next;
        p = head;
        for (int i = 0; i < c - n; ++i) {
            p = p.next;
        }

        // swap
        p.next = p.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null) return head;

        // 快慢指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i=0 ; i<n; i++) {
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        // 删除目标节点
        q.next = q.next.next;
        return dummy.next;
    }

}
