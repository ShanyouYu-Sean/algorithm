package algorithm.list;

import algorithm.entity.ListNode;

/**
 * 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为:
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */
public class ReorderList {

    // 重排链表
    // 1、找到原链表的中点 2、将原链表的右半端反转 3、将原链表合并
    public void reorderList(ListNode head){
        if (head == null){
            return;
        }
        ListNode mid = middle(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        merge(l1, l2);
    }
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    public void merge(ListNode l1, ListNode l2){
        while (l1 != null && l2 != null){
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            l1 = tmp1;
            l2.next = l1;
            l2 = tmp2;
        }
    }
}
