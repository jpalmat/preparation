package javaPrep.datastructure.tree.redblacktree;

public class Main {
    public static void main(String[] args)
    {
        // let us try to insert some data into tree and try to visualize the tree as well as traverse.
        RedBlackTree t = new RedBlackTree();
        int[] arr = {1,4,6,3,5,7,8,2,9};
        for(int i=0;i<9;i++)
        {
            t.insert(arr[i]);
            System.out.println();
            t.inorderTraversal();
        }
        // you can check colour of any node by with its attribute node.colour
        t.printTree();
    }
}