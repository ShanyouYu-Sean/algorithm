package algorithm.tree;

import fucktencent.algorithm.entity.TreeNode;

/**
 * 二叉树展开为列表
 * 后序遍历，取出左右子树，左子变右子，右子接到最右端
 */
public class TreeToList {

    // 二叉树展开为列表
    // 后序遍历，取出左右子树，左子变右子，右子接到最右端
    public void flatten(TreeNode root){
        if (root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        // 后序遍历位置
        // 1、取出左右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;
        // 3、右子树接到最右端
        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
    }
}
