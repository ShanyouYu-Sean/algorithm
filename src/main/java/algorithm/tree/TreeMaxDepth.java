package algorithm.tree;

import algorithm.entity.TreeNode;

/**
 * 二叉树的最大深度
 * 递归左右子节点，去最大值 + 1
 */
public class TreeMaxDepth {

    // 二叉树的最大深度
    // 递归左右子节点，去最大值 + 1
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
