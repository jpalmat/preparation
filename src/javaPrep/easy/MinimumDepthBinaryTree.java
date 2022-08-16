package javaPrep.easy;

import java.util.LinkedList;

public class MinimumDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        TreeNode twnty = new TreeNode(20, fifteen, seven);
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3, nine, twnty);

        System.out.println(minDepth(three));
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();

        nodes.add(root);
        counts.add(1);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();

            if(curr.left == null && curr.right == null){
                return count;
            }

            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
        }

        return 0;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
 }
}