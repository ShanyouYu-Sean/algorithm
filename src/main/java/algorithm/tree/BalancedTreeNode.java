package algorithm.tree;

import fucktencent.algorithm.entity.TreeNode;

/**
 * 是否是平衡二叉树
 */
public class BalancedTreeNode {
    // 是否是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = depth(root.left);
        if(left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if(right == -1){
            return -1;
        }
        if(left - right < -1 || left - right > 1){
            return -1;
        }else{
            // 树的深度
            return  Math.max(left, right) + 1;
        }
    }
}
