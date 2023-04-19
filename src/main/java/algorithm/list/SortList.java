package algorithm.list;

import fucktencent.algorithm.entity.ListNode;

/**
 * 链表排序
 * 1、找到链表的中点，以中点为分界，将链表拆成两个子链表，
 *    寻找链表的中点可以使用快慢指针
 * 2、对两个链表分别排序，之后将两个排序后的子链表合并，得到完整的排序后的链表
 */
public class SortList {

    /**
     * 链表排序
     * 1、找到链表的中点，以中点为分界，将链表拆成两个子链表，
     *    寻找链表的中点可以使用快慢指针
     * 2、对两个链表分别排序，之后将两个排序后的子链表合并，得到完整的排序后的链表
     */
    public ListNode sortList(ListNode head){
        return sortList(head, null);
    }
    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }
    // 合并两个有序链表
    public ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
