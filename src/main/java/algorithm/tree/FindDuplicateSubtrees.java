package algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithm.entity.TreeNode;

/**
 * 寻找重复的子树
 * 序列化一棵树，存到map里
 */
public class FindDuplicateSubtrees {

    // 寻找重复的子树，序列化一棵树，存到map里
    Map<String, Integer> tmpMap = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        if (root == null){
            return null;
        }
        count(root);
        return res;
    }
    String count(TreeNode root){
        if (root == null){
            return "#";
        }
        String serial = root.val + "," + count(root.left) + "," + count(root.right);
        if (tmpMap.get(serial) == null){
            tmpMap.put(serial, 1);
        }else {
            tmpMap.put(serial, tmpMap.get(serial) + 1);
        }
        if (tmpMap.get(serial) == 2){
            res.add(root);
        }
        return serial;
    }
}
