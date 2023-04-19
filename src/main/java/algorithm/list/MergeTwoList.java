package algorithm.list;

import fucktencent.algorithm.entity.ListNode;

/**
 * 合并有序链表
 */
public class MergeTwoList {

    // 合并有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
         // 针对链表不一样长的情况
         p.next = l1 == null ? l2 : l1;
         return dummy.next;
    }

    // 合并K个链表
    public ListNode mergeKList(ListNode[] lists){
        if (lists.length == 0) {
            return null;
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++){
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
}
