package javaPrep.datastructure.tree.redblacktree;

public class Node {
    private Node parent;
    private Node letfChild;
    private Node rightChild;
    private int heighProperty;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLetfChild() {
        return letfChild;
    }

    public void setLetfChild(Node letfChild) {
        this.letfChild = letfChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getHeighProperty() {
        return heighProperty;
    }

    public void setHeighProperty(int heighProperty) {
        this.heighProperty = heighProperty;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}