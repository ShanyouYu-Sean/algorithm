package algorithm.tree;

import algorithm.entity.TreeNode;

/**
 * 删除二叉搜索树的节点
 * 二叉搜索树（BST）左小右大
 */
public class BST {

    // 二叉搜索树系列
    // 插入节点
    public TreeNode insertNode(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val > val){
            root.left = insertNode(root.left, val);
        }
        if (root.val < val){
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    // 删除节点
    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null){
            return null;
        }
        if (root.val == key){
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            // 如果删除的节点有两个孩子，必须找到右子树中最小的孩子
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node){
        // BST 最左边的就是最小的
        while (node.left != null){
            node = node.left;
        }
        return node;
    }


     // 搜索节点
    public TreeNode searchNode(TreeNode root, int val){
        if (root == null){
            return root;
        }
        if (root.val == val){
            return root;
        }else if (root.val > val){
            return searchNode(root.left, val);
        }else {
            return searchNode(root.right, val);
        }
    }


    // 验证二叉搜索树
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    // 左子树小于max（root），右子树大于min（root），递归
    boolean isValidBST(TreeNode root, TreeNode max, TreeNode min){
        if (root == null){
            return true;
        }
        if (max != null && root.val >= max.val){
            return false;
        }
        if (min != null && root.val <= min.val){
            return false;
        }
        return isValidBST(root.left, root, min) &&
                isValidBST(root.right, max, root);
    }
}
