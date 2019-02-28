package lc021tolc040.lc023;

import java.util.Comparator;
import java.util.PriorityQueue;

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
      ListNode(int x) { val = x; }
    }

    /**
     * Brute Force
     */
    public ListNode mergeKLists001(ListNode[] lists) {
        if(null == lists || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode a = lists[0];

        for(int i=1; i<lists.length; ++i) {
            a = mergeTwoList(a,lists[i]);
        }

        return a;
    }
    private ListNode mergeTwoList(ListNode a, ListNode b) {
        if (b == null) return a;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (null!=a && null != b) {
           if(a.val < b.val) {
               current.next = a;
               a = a.next;
           }
           else {
               current.next = b;
               b = b.next;
           }
           current=current.next;
        }
        current.next = a == null ? b:a;
        return dummy.next;
    }

    /**
     * Priority Queue
     */
    public ListNode mergeKLists002(ListNode[] lists) {

        if(null == lists || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        PriorityQueue<ListNode> priorityQueue =
                new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1.val<o2.val)
                            return -1;
                        else if (o1.val==o2.val)
                            return 0;
                        else
                            return 1;
                    }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode list : lists) {
            if (null != list)
                priorityQueue.add(list);
        }
        // interesting
        while (!priorityQueue.isEmpty()) {
            tail.next = priorityQueue.poll();
            tail = tail.next;

            if (tail.next != null)
                priorityQueue.add(tail.next);
        }
        return dummy.next;
    }

    /**
     * Divide and Conquer
     */
    public ListNode mergeKLists003(ListNode[] lists) {
        return part(lists,0,lists.length-1);
    }
    private ListNode part(ListNode[] lists, int l, int r) {
        if(l == r) return lists[l];

        if(l<r) {
            int q = (l + r) / 2;
            ListNode l1 = part(lists,l,q);
            ListNode l2 = part(lists,q+1,r);
            return mergeTwoList(l1,l2);
        }
        else
            return null;
    }
}
