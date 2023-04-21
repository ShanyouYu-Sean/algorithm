package algorithm.list;

import algorithm.entity.ListNode;

/**
 * 反转链表
 */
public class ReverseList {

    // 反转链表
    public ListNode reverseList(ListNode head){
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

}
