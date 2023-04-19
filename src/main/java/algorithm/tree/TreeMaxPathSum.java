package algorithm.tree;

import fucktencent.algorithm.entity.TreeNode;

/**
 * 二叉树的最大路径和
 */
public class TreeMaxPathSum {

    // 二叉树的最大路径和
    private int res = Integer.MIN_VALUE;
    // 对于任意一个节点，如果最大路径包含该节点，那么只可能有两种情况：
    // 1、左右子树中所构成的路径和较大的那个，加上该节点的值后，向父节点回溯构成最大路径。
    // 2、左右子树都在最大路径中，加上该节点的值构成了最终的最大路径
    public int maxPathSum(TreeNode root){
        getMax(root);
        return res;
    }
    private int getMax(TreeNode r){
        if (r == null){
            return 0;
        }
        // 如果子树路径和为负则应当置0，表示最大路径不包含子树
        int left = Math.max(0, getMax(r.left));
        int right = Math.max(0, getMax(r.right));
        res = Math.max(res, r.val + left + right);
        return Math.max(left, right) + r.val;
    }
}
