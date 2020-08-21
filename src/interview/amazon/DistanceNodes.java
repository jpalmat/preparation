package interview.amazon;

import java.util.List;
/*
A binary search tree (BST) is defined as a binary tree in which each node satishes the property such that its value is larger than the value
of every node in its le vubtree,
and less
than or equal to the value of every node in its right for the distance between two values in a binary search tree is the minimum number of

edges traversed to reach from one value to the other

Given a list of n unique integers, construct a BST by inserting each integer in the ven order without rebalancing the tree They find the
distance between the two ven nodes, nadet and
node2 of the BST. In case the nodet or node is not present in the tree return 1.

Input The input to the function method consists of three arguments

values representing a list of integers:

node1 an integer representing the first node, and

node2. an integer representing the second node

Return an integer representing the distance between node and node 2. elsa return -1, Feather nadal or node is not present in the tree
 */
public class DistanceNodes
{
    public static void main(String[] args) {

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode rigth;

        TreeNode(int x, TreeNode l, TreeNode r){
            this.val = x;
            this.left = l;
            this.rigth = r;
        }
    }

    public static int foo(List<Integer> values, int node1, int node2){
        TreeNode root = new TreeNode(values.get(0), null, null);
        TreeNode currNode = root;
        for(int i = 1; i < values.size(); ++i){
        }
        return 0;
    }

}
