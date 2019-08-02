package com.code.leetcode.learn.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Number2 {
    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        orderByMiddle(root, list);
        for (int i=0;i<list.size()-1;i++){
            if (list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void orderByMiddle(TreeNode treeNode, List<Integer> list){
        if (null == treeNode) {
            return;
        }
        orderByMiddle(treeNode.left, list);
        list.add(treeNode.val);
        orderByMiddle(treeNode.right, list);

    }

}
