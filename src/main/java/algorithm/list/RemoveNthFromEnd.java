package algorithm.list;

import algorithm.entity.ListNode;

/**
 * 删除链表的倒数第n个节点并返回链表的头指针
 * 双指针
 * 快指针先走n步，然后一起走到底，再删除
 */
public class RemoveNthFromEnd {

    // 删除链表的倒数第n个节点并返回链表的头指针
    // 快指针先走n步，然后一起走到底，再删除
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i ++){
            fast = fast.next;
        }
        if (fast == null){
            return head.next;
        }
        while (fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
