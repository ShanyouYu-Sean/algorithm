package algorithm.tree;

import algorithm.entity.TreeNode;

/**
 * 树的镜像
 * 先前序遍历这课树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点，
 * 当交换完多有非叶子节点的子节点后，就是数的镜像
 */
public class MirrorTree {

    // 树的镜像
    // 先前序遍历这课树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点，
    // 当交换完多有非叶子节点的子节点后，就是数的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null){
            mirrorTree(root.left);
        }
        if (root.right != null){
            mirrorTree(root.right);
        }
        return root;
    }

}
