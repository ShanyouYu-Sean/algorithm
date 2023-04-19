package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import fucktencent.algorithm.entity.TreeNode;

public class InorderTraversal {

	// 中序遍历
	// 非递归
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stk = new Stack<>();
		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				// 前序写这里
				stk.push(root);
				root = root.left;
			}
			root = stk.pop();
			// 中序写这里
			res.add(root.val);
			root = root.right;
		}
		return res;
	}
	// 后序遍历
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.right == null || root.right == prev) {
				res.add(root.val);
				prev = root;
				root = null;
			} else {
				stack.push(root);
				root = root.right;
			}
		}
		return res;
	}

}
