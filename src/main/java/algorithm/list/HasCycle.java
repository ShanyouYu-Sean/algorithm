package algorithm.list;

import algorithm.entity.ListNode;

/**
 * 链表有环
 */
public class HasCycle {

    // 链表有环
    // 快慢指针
    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    // 快慢指针后，再加入一个指针，跟慢指针同步，相遇时即为入环点
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode ptr = head;
                while(ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
