package lc876链表的中间结点;

import common.ListNode;

/**
 * @author dxd
 * @date 2020/1/3
 */
public class Solution {
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    //快慢指针
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
