package lc021tolc040.lc024;

/**
 * Created on 2019/2/28<br>
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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        dummy.next = head;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }

        return dummy.next;
    }

}
