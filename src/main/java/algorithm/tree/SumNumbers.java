package algorithm.tree;

import fucktencent.algorithm.entity.TreeNode;

public class SumNumbers {

	// 根节点到叶节点数字之和
	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}
	private int sumNumbers(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}
		int curSum = sum * 10 + node.val;
		if (node.left == null && node.right == null) {
			return curSum;
		}
		return sumNumbers(node.left, curSum) + sumNumbers(node.right, curSum);
	}

}
