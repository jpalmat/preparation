package javaPrep.datastructure.tree.redblacktree;

public class RedBlackTree extends BalanceableTree {

    public RedBlackTree(int value) {
        super(value);
    }

    private boolean isBlack(Node node) {
        return node.getHeighProperty() == 0;
    }

    private boolean isRed(Node node) {
        return node.getHeighProperty() == 1;
    }

    private void makeBlack(Node node) {
        node.setHeighProperty(0);
    }

    private void makeRed(Node node) {
        node.setHeighProperty(1);
    }

    private void setColor(Node node, boolean toRed) {
        node.setHeighProperty(toRed ? 1 : 0);
    }

    public void rebalanceInsert(Node node) {
        if(node != getRoot()) {
            makeRed(node);
            resolveRed(node);
        }
    }

    private void resolveRed(Node node) {
        Node parent, sibling, middle, grandparent;
        parent = node.getParent();

        if(isRed(parent)){
            sibling = sibling(parent);

            if(sibling == null || isBlack(sibling)) {
                middle = restructure(node);
                makeBlack(middle);
                makeRed(middle.getLetfChild());
                makeRed(middle.getRightChild());
            } else {
                makeBlack(parent);
                makeBlack(sibling);

                grandparent = parent.getParent();
                if(grandparent != getRoot()) {
                    makeRed(grandparent);
                    resolveRed(grandparent);
                }
            }
        }
    }

    public void rebalanceDelete(Node node) {
        if(isRed(node)) {
            makeBlack(node);
        } else if (node != getRoot()) {
            Node sibling = sibling(node);
            if(isInternal(sibling) && (isBlack(sibling) || isInternal(sibling.getLetfChild()))) {
                remedyDoubleBlack(node);
            }
        }
    }

    private Node sibling(Node node) {
        Node parent = node.getParent();
        if(parent == null) {
            return null;
        }

        if(node == parent.getLetfChild()) {
            return parent.getRightChild();
        } else {
            return parent.getLetfChild();
        }
    }

    private void remedyDoubleBlack(Node node) {
        Node z = node.getParent();
        Node y = sibling(node);

        if(isBlack(y)) {
            if(isRed(node.getLetfChild()) || isRed(node.getRightChild())) {
                Node x = (isRed(y.getLetfChild()) || ? y.getLetfChild() : y.getRightChild());
                Node middle = restructure(x);
                setColor(middle, isRed(z));
                makeBlack(middle.getLetfChild());
                makeBlack(middle.getRightChild());
            } else {
                makeRed(y);
                if(isRed(z)) {
                    makeBlack(z);
                } else {
                    if(z != getRoot()) {
                        remedyDoubleBlack(z);
                    }
                }
            }
        } else {
            rotate(y);
            makeBlack(y);
            makeRed(z);
            remedyDoubleBlack(node);
        }
    }
}