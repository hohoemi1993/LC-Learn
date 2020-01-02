package lc141环形链表;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode p;
        p = head;
        while (p != null) {
            if (map.containsKey(p)) return true;
            map.put(p, 1);
            p = p.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
