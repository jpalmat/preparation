package javaPrep.easy;

import javaPrep.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode tree31 = new TreeNode(3, null, null);
        TreeNode tree32 = new TreeNode(3, null, null);

        TreeNode tree41 = new TreeNode(4, null, null);
        TreeNode tree42 = new TreeNode(4, null, null);

        TreeNode tree21 = new TreeNode(2, tree31, tree41);
        TreeNode tree22 = new TreeNode(2, tree42, tree32);

        TreeNode tree1 = new TreeNode(1, tree21, tree22);

        System.out.println(isSymmetric(tree1));

    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
    }
}