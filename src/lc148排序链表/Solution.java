package lc148排序链表;

import common.ListNode;
import javax.swing.Spring;

public class Solution {
  public ListNode sortList(ListNode head) {
    if (null == head) return head;
    return mergeSort(head);
  }

  private ListNode mergeSort(ListNode head) {
    if (head.next == null) return head;
    ListNode mid = head;
    ListNode j = head;
    int count = 0;
    while (j.next != null && j.next.next !=null) {
      mid = mid.next;
      j = j.next.next;
      count++;
    }
    if (count > 3) {
      ListNode right = mergeSort(mid.next);
      mid.next = null;
      ListNode left = mergeSort(head);
      // merge
      return merge(left, right);
    } else {
      return insertionSortList(head);
    }
  }


  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode();
    ListNode p = dummy;
    while (left != null || right != null) {
      while (left == null && right != null) {
        p.next = right;
        p = p.next;
        right = right.next;
      }
      while (right == null && left != null) {
        p.next = left;
        p = p.next;
        left = left.next;
      }
      if (left != null) {
        if (left.val > right.val) {
          p.next = right;
          p = p.next;
          right = right.next;
        } else {
          p.next = left;
          p = p.next;
          left = left.next;
        }
      }
    }
    return dummy.next;
  }

  private ListNode insertionSortList(ListNode head) {
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

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(4);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(1);
    ListNode listNode4 = new ListNode(3);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;

    Solution solution = new Solution();
    ListNode listNode = solution.sortList(listNode1);
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }

  }
}
