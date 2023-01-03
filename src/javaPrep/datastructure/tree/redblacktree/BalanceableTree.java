package javaPrep.datastructure.tree.redblacktree;

public class BalanceableTree {
    private Node root;

    public BalanceableTree(int value) {
        root = new Node(value);
    }

    public Node getRoot(){
        return root;
    }

    public Node search(int key){
        Node nodeFound = searchHelper(root, key);
        rebalanceAccess(nodeFound);
        return nodeFound;
    }

    public int insert(int key){
        Node newNode = new Node(key);
        
        Node foundNode = searchHelper(root, key);
        
        if(foundNode == null) {
            foundNode = foundNode.getParent();
        }
        
        if(foundNode.getValue() == key) {
            rebalanceAccess(foundNode);
        } else {
            if(key < foundNode.getValue()){
                foundNode.setLetfChild(newNode);
            } else {
                foundNode.setRightChild(newNode);
            }
            newNode.setParent(foundNode);
            rebalanceInsert(newNode);
        }

        return key;
    }

    public int delete(int key){
        Node foundNode = searchHelper(root, key);

        if(foundNode.getValue() == key) {
            return removeHelper(foundNode, key);
        }
        return key;
    }

    private int removeHelper(Node node, int key) {
        Node successor = node;

        if(hasNoChildren(node)){
            removeLeafNode(node, node.getValue());
        }

        if(hasOneChlid(node)) {
            replaceNodeWithChildren(node);
        }

        if(hasTwoChildren(node)){
            successor = getInOrderSuccessor(node.getRightChild());
            node.setValue(successor.getValue());
            removeHelper(successor, successor.getValue());
        }

        rebalanceDelete(successor.getParent());

        return node.getValue();
    }

    public void rotate(Node node) {
        Node x = node;
        Node y = x.getParent();
        Node z = y. getParent();

        if(z == null) {
            root = x;
            x.setParent(null);
        } else {
            relink(z, x, y == z.getLetfChild());
        }

        if(x == y.getLetfChild()){
            relink(y, x.getRightChild(), true);
            relink(x, y, false);
        } else {
            relink(y, x.getLetfChild(), false);
            relink(x, y, true);
        }
    }

    public Node restructure(Node x) {
        Node y = x.getParent();
        Node z = y.getParent();

        if((x == y.getRightChild() == (y == z.getRightChild()))) {
            rotate(y);
            return y;
        } else {
            rotate(x);
            rotate(x);
            return x;
        }
    }

    private void relink(Node parent, Node child, boolean makeLeftChild) {
        if(child != null) {
            child.setParent(parent);
        }

        if(makeLeftChild) {
            parent.setLetfChild(child);
        } else {
            parent.setRightChild(child);
        }
    }

    public void inorder(Node node) {
        if(node != null) {
            inorder(node.getLetfChild());
            printNode(node);
            inorder(node.getRightChild());
        }
    }

    private void printNode(Node node) {
        if(node.getValue() == getRoot().getValue()) {
            System.out.println("Root node: "+ node.getValue());
        } else {
            System.out.println("Current node: "+ node.getValue());
        }

        printInformation(node.getParent(), "Parent: ");
        printInformation(node.getLetfChild(), "Left child: ");
        printInformation(node.getRightChild(), "Right child: ");
        System.out.println("Height property: " + node.getHeighProperty());

        System.out.println();
    }

    private void printInformation(Node node, String string) {
        if(node != null) {
            System.out.println(string + node.getValue());
        }
    }

    public boolean isInternal(Node node) {
        return hasOneChlid(node) || hasTwoChildren(node);
    }

    private Node getInOrderSuccessor(Node node) {
        while (node.getLetfChild()!= null) {
            node = node.getLetfChild();
        }
        return node;
    }

    private void replaceNodeWithChildren(Node node) {
        Node child = node.getLetfChild() != null ? node.getLetfChild() : node.getRightChild();

        if(child != null){
            child.setParent(node.getParent());
        } else {
            Node parent = node.getParent();
            if (node == parent.getLetfChild()){
                parent.setLetfChild(child);
            } else {
                parent.setRightChild(child);
            }
        }
    }

    private void removeLeafNode(Node node, int value) {
        Node parentNode;

        if(node.getParent() != null) {
            parentNode = node.getParent();
        } else {
            parentNode = node;
        }

        if(parentNode.getLetfChild() != null && parentNode.getLetfChild().getValue()==value) {
            parentNode.setLetfChild(null);
        } else {
            parentNode.setRightChild(null);
        }
    }

    private boolean hasTwoChildren(Node node) {
        return node.getLetfChild()!=null && node.getRightChild()!=null;
    }

    private boolean hasOneChlid(Node node) {
        return (node.getLetfChild()!= null && node.getRightChild()==null) || (node.getLetfChild()== null && node.getRightChild()!=null);
    }

    private boolean hasNoChildren(Node node) {
        return node.getLetfChild()==null && node.getRightChild()==null;
    }

    private void rebalanceInsert(Node node) {
    }

    private void rebalanceAccess(Node node) {

    }

    private void rebalanceDelete(Node node) {

    }

    private Node searchHelper(Node node, int key) {
        if(key == node.getValue()) {
            return node;
        } else if (key < node.getValue()) {
             if(node.getLetfChild() == null) {
                 return node;
             }
             return searchHelper(node.getLetfChild(), key);
        } else {
            if(node.getRightChild() == null) {
                return node;
            }
            return searchHelper(node.getRightChild(), key);
        }
    }
}
