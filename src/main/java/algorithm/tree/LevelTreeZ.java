package algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithm.entity.TreeNode;

/**
 * Z字型层序遍历
 * 偶数层头插
 */
public class LevelTreeZ {

    // Z 字型层序遍历，偶数层头插
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if (level % 2 == 1) {
                    list.add(node.val);
                }else {
                    list.add(0, node.val);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            level ++;
            res.add(list);
        }
        return res;
    }

}
