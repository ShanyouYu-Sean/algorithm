package algorithm.tree;

import algorithm.entity.TreeNode;

/**
 * 翻转二叉树
 * 前序遍历交换左右节点
 */
public class InvertTree {

    // 翻转二叉树，前序遍历交换左右节点
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
