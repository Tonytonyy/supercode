package com.code.leetcode.learn.tree;

import java.util.ArrayList;
import java.util.List;

public class Number4 {
    /***
     * 二叉树的层次遍历
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    /***
     * 深度优先搜索（DFS）
     *
     * 在这个策略中，我们采用深度作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回根到达另一个分支。
     *
     * 深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为先序遍历，中序遍历和后序遍历。
     *
     * 宽度优先搜索（BFS）
     *
     * 我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。
     *
     */
    List<List<Integer>> levels = new ArrayList<>();

    public void helper(TreeNode node, int level) {
        if (level == levels.size()){
            levels.add(new ArrayList<>());
        }
        if (null != node){
            levels.get(level).add(node.val);
        }
        if (node.left != null){
            helper(node.left, level +1 );
        }
        if (node.right != null){
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

}
