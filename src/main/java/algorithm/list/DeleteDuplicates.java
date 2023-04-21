package algorithm.list;

import algorithm.entity.ListNode;

public class DeleteDuplicates {

	// 删除链表中的重复节点，保留一个重复值
	public ListNode deleteDuplicates1(ListNode head) {
		if (head == null) { return head; }
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

		return head;
	}

	// 删除链表中的重复节点，不保留重复值
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null) { return head; }
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int x = cur.next.val;
				while (cur.next != null && cur.next.val == x) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}
