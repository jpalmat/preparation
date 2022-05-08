package javaPrep.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode tre1 = new TreeNode(4, null, null);
        TreeNode tre2 = new TreeNode(5, null, null);
        TreeNode tre3 = new TreeNode(2, tre1, tre2);
        TreeNode tre4 = new TreeNode(3, null, null);
        TreeNode tre5 = new TreeNode(1, tre3, tre4);

        TreeNode tre6 = new TreeNode(4, null, null);
        TreeNode tre7 = new TreeNode(5, null, null);
        TreeNode tre8 = new TreeNode(2, tre6, tre7);
        TreeNode tre9 = new TreeNode(3, null, null);
        TreeNode tre10 = new TreeNode(1, tre8, tre9);

//        TreeNode tree = new TreeNode(1, null, null);
//        TreeNode tree1 = new TreeNode(1, tree, null);
//        TreeNode tree2 = new TreeNode(1, null, null);
//        TreeNode tree3 = new TreeNode(1, null, tree2);

        System.out.println(isSameTree(tre5, tre10));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if(p == null || q == null) {
            return false;
        } else if(p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }
}