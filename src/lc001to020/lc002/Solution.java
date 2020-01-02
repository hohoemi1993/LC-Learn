package lc001to020.lc002;

/**
 * l1 and l2 are reverse-ordered
 */
class Solution {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Elementary Math
     * <p>
     * Time complexity :O(max(m,n)).
     * Space complexity :O(max(m,n)).
     */
    public ListNode addTwoNumbers001(ListNode l1, ListNode l2) {
        // just a holder
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        ListNode p = l1;
        ListNode q = l2;

        int carry = 0;

        // end with reaching the longer link-list l1 or l2
        while (p != null || q != null) {
            // pad zero
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            // calc
            int sum = carry + x + y;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            // move point
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        // the highest digit (1 or none)
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
