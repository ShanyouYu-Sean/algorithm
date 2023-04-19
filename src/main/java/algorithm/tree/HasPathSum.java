package algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import fucktencent.algorithm.entity.TreeNode;

public class HasPathSum {

	// 路径和存在
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		return hasPathSum(root.left, sum - root.val) ||
				hasPathSum(root.right, sum - root.val);
	}

	// 获得所有存在的路径和
	List<List<Integer>> ret = new LinkedList<>();
	Deque<Integer> path = new LinkedList<>();
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		dfs(root, targetSum);
		return ret;
	}
	public void dfs(TreeNode root, int targetSum) {
		if (root == null) {
			return;
		}
		path.offerLast(root.val);
		targetSum -= root.val;
		if (root.left == null && root.right == null && targetSum == 0) {
			ret.add(new LinkedList<>(path));
		}
		dfs(root.left, targetSum);
		dfs(root.right, targetSum);
		path.pollLast();
	}

}
