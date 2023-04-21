package algorithm.tree;

import algorithm.entity.TreeNode;

/**
 * 对称二叉树
 * 判断一个二叉树是否是镜像对称的
 * 比较值 & 左右递归 & 右左递归
 */
public class SymmetricTree {

    // 对称二叉树
    // 判断一个二叉树是否是镜像对称的
    // 比较值 & 左右递归 & 右左递归
    public boolean isSymmetric(TreeNode root){
        return check(root, root);
    }
    public boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
