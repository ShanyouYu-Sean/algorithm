package algorithm.tree;

import algorithm.entity.TreeNode;

public class DiameterOfBinaryTree {

	// 二叉树的直径
	int maxd=0;
	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return maxd;
	}
	public int depth(TreeNode node){
		if(node==null){
			return 0;
		}
		int left = depth(node.left);
		int right = depth(node.right);
		//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
		maxd=Math.max(left+right,maxd);
		//返回节点深度
		return Math.max(left,right)+1;
	}

}
