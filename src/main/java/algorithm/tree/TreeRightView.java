package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import fucktencent.algorithm.entity.TreeNode;

/**
 * 二叉树的右视图
 * 使用层序遍历，并只保留每层最后一个节点的值
 */
public class TreeRightView {

    // 二叉树的右视图
    // 使用层序遍历，并只保留每层最后一个节点的值
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                // 将当层的最后一个节点放入结果列表
                if (i == size - 1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
