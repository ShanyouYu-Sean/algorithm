package algorithm.list;

import fucktencent.algorithm.entity.ListNode;

/**
 * 链表 m 到 n 之间反转
 */
public class ReverseBetween {

    // 链表 m 到 n 之间反转
    public ListNode reverseBetween(ListNode head, int m, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for (int i = 1; i < m; i++){
            pre = cur;
            cur = cur.next;
        }
        for (int i = 0; i < n - m; i++){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }

}
