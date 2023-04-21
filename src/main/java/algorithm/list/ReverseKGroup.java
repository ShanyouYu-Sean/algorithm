package algorithm.list;


import algorithm.entity.ListNode;

/**
 * K个一组翻转链表的通用实现，快慢指针-链表反转。
 */
public class ReverseKGroup {

    // K个一组翻转链表，快慢指针-链表反转。
    public ListNode reverseKGroup(ListNode head, int k) {
        // 哑结点
        ListNode dummy = new ListNode(-1, head);
        // 子链表头结点的前驱结点
        ListNode subListPreHead = dummy;
        // 快慢指针
        // 慢指针指向头结点
        ListNode slow = head;
        // 快指针指向尾结点的next结点
        ListNode fast = head;
        while (fast != null) {
            // K个一组
            int nodeNum = 0;
            for (; nodeNum < k && fast != null; nodeNum ++){
                fast = fast.next;
            }
            if (nodeNum == k){
                // 链表反转，slow头结点变为尾结点
                subListPreHead.next = reverse(slow, fast);
                subListPreHead = slow;
                slow = fast;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head, ListNode tail){
        ListNode cur = head;
        ListNode pre = tail;
        while (cur != tail){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
