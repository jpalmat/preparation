package javaPrep.easy;

import javaPrep.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {

        TreeNode tre1 = new TreeNode(4, null, null);
        TreeNode tre2 = new TreeNode(5, null, null);
        TreeNode tre3 = new TreeNode(2, tre1, tre2);
        TreeNode tre4 = new TreeNode(3, null, null);
        TreeNode tre5 = new TreeNode(1, tre3, tre4);

        inorderTraversal(tre5).stream().forEach(x -> System.out.println(x));
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }

}