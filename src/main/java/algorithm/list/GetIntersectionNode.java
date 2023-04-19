package algorithm.list;

import fucktencent.algorithm.entity.ListNode;

/**
 * 找到两个链表的第一个公共节点
 */
public class GetIntersectionNode {

    // 找到两个链表的第一个公共节点
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2){
            if (p1 == null || p2 == null){return null;}
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2){
                if (p1 == null) {p1 = headA;}
                if (p2 == null) {p2 = headB;}
            }
        }
        return p1;
    }
}
