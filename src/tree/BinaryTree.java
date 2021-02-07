package tree;

public class BinaryTree<T extends Comparable<T>> {
    private Node root;
    private int size;

    public BinaryTree() {
        this.root = null;
    }

    public void add(T data) {
        // Create a node with the data
        Node node = new Node(data);
        // Check if the tree is empty, and set new node as root node
        if (this.root == null) {
            this.root = node;
            size++;
        }   
        // Otherwise insert the new node using binary tree insert algorithm
        else {
            insert(this.root, node);
        }
    }

    public void insert(Node parent, Node child) {
        // If the child is less than the parent, it goes on the left
        if (child.getData().compareTo(parent.getData()) < 0) {
            // If the left node of the parent is null then insert the node
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            }
            // Otherwise call insert method recursively
            else {
                insert(parent.getLeft(), child);
            }
        }

        // Otherwise if the child is greater than the parent, it goes on the right
        else if (child.getData().compareTo(parent.getData()) > 0) {
            // If the right node is null, insert the node 
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            }
            // Otherwise call insert recursively for next node 
            else{
                insert(parent.getRight(), child);
            }
        }

        // If both the child and the parent are equal then ingnore, if the tree should
        // not contain duplicate
    }

    public int size() {
        return size;
    }

    private class Node {
        private Node parent;
        private Node left;
        private Node right;
        private T data;

        public Node(T data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;

        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }

}
