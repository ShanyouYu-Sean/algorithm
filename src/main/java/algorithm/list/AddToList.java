package algorithm.list;

import java.util.Stack;

import fucktencent.algorithm.entity.ListNode;

public class AddToList {
	// 链表中的数相加
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (l1 != null){
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null){
			stack2.push(l2.val);
			l2 = l2.next;
		}

		ListNode head = null;
		int c = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty() || c != 0){
			int a = !stack1.isEmpty() ? stack1.pop() : 0;
			int b = !stack2.isEmpty() ? stack2.pop() : 0;
			head = new ListNode((a+b+c)%10, head);
			c = (a+b+c)/10;
		}
		return head;
	}
}
