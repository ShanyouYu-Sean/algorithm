package algorithm.tree;

import fucktencent.algorithm.entity.TreeNode;

/**
 * 二叉树的最近公共祖先
 */
public class CommonAncestor {

    // 二叉树的最近公共祖先
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = commonAncestor(root.left, p, q);
        TreeNode right = commonAncestor(root.right, p, q);
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }

}
