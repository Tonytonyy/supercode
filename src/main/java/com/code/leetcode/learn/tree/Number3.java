package com.code.leetcode.learn.tree;

public class Number3 {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * 说明:
     *
     * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
     */

    public boolean isSymmetric(TreeNode root) {
        if (null == root){
            return true;
        }
        return isSymmetric2(root.left, root.right);
    }
    public boolean isSymmetric2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null ){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }

        if (root1.val != root2.val ){
            return false;
        }

        return isSymmetric2(root1.left, root2.right) && isSymmetric2(root1.right, root2.left);


    }
}
