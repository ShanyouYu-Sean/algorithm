package algorithm.list;

import fucktencent.algorithm.entity.ListNode;

public class KthFromEnd {

	// 链表的倒数第 k 个节点
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode former = head, latter = head;
		for(int i = 0; i < k; i++)
			former = former.next;
		while(former != null) {
			former = former.next;
			latter = latter.next;
		}
		return latter;
	}
}
