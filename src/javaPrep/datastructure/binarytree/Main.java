package javaPrep.datastructure.binarytree;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        System.out.println("\ninOrder");
        bt.traverseInOrder(bt.root);

        System.out.println("\npreOrder");
        bt.traversePreOrder(bt.root);

        System.out.println("\npostOrder");
        bt.traversePostOrder(bt.root);

        System.out.println("\nBreadth first search");
        bt.traverseLevelOrder();
    }
}