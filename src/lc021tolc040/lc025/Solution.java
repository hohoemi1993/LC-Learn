package lc021tolc040.lc025;

import common.ListNode;

/**
 * Created on 2019/4/10<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || k == 1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        ListNode next = dummy;
        int length = 0;
        while (cur.next != null) {
            cur =  cur.next;
            length++;
        }

        while (length >= k) {
            cur = pre.next;
            next = cur.next;
            for (int i=1; i<k; i++) {
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
            }
            pre = cur;
            length -= k;
        }

        return dummy.next;
    }

}