package algorithm.tree;

import java.util.HashMap;
import java.util.Map;

import fucktencent.algorithm.entity.TreeNode;

/**
 * 根据前序遍历和中序遍历构造一颗二叉树
 * 前序 preleft，preleft + 1 ～ x ， x + 1 ， preright
 * 中序 inleft ～ inmid - 1 ， inmid ， inmid + 1 ～ inright
 * x - （preleft + 1） = inmid - 1 - inleft
 * x = inmid - inleft + preleft
 */
public class BuildTree {

    // 根据前序遍历和中序遍历构造一颗二叉树
    // 前序 preleft，preleft + 1 ～ x ， x + 1 ， preright
    // 中序 inleft ～ inmid - 1 ， inmid ， inmid + 1 ～ inright
    // x - （preleft + 1） = inmid - 1 - inleft
    // x = inmid - inleft + preleft
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++){
            inMap.put(inorder[i], i);
        }
        return convert(
                preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1,
                inMap
        );
    }
    public TreeNode convert(int[] preorder, int preleft, int preright,
                            int[] inorder, int inleft, int inright,
                            Map<Integer, Integer> inMap){
        if (preleft > preright || inleft > inright){
            return null;
        }
        int rootVal = preorder[preleft];
        TreeNode root = new TreeNode(rootVal);
        int inmid = inMap.get(rootVal);
        root.left = convert(
                preorder, preleft + 1, inmid - inleft + preleft,
                inorder, inleft, inmid - 1, inMap);
        root.right = convert(
                preorder, inmid - inleft + preleft + 1, preright,
                inorder, inmid + 1, inright, inMap);
        return root;
    }

}
