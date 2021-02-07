package linkedlist;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to add to the list
    public void add(T item) {
        // Check if this is the first item to be added
        if (head == null) {
            head = new Node(item);
            tail = head;
        }
        // Otherwise grab the last node and set its value
        else {
            Node newNode = new Node(item);
            // tail.next = newNode;
            tail.setNextNode(newNode);
            tail = newNode;

        }
        size++;
    }

    // Method to insert an item at a given position
    public void insert(T item, int position) {
        // Check if the position is valid
        if (position > size() || position < 0) {
            throw new IllegalStateException("Invalid position, the size of the list is : " + size());
        }
        Node current = head;
        for (int i = 0; i < position && current != null; i++) {
            // current = current.next;
            current = current.getNextNode();
        }
        Node newNode = new Node(item);
        // Node nextNode = current.next;
        Node nextNode = current.getNextNode();
        // current.next = newNode;
        current.setNextNode(newNode);
        // newNode.next = nextNode;
        newNode.setNextNode(nextNode);
        size++;
    }

    // Method to remove the last item from the list
    public T remove() {
        // Check if the list is empty
        if (head == null) {
            throw new IllegalStateException("The list is empty and there is no item to remove");
        }
        T removedItem = head.getNodeItem();
        // head = head.next;
        head = head.getNextNode();
        size--;
        return removedItem;
    }

    // Method to remove an item at a given position
    public T removeAt(int position) {
        // Check if the list is empty
        if ((head == null) || (position > size() || position < 0)) {
            throw new IllegalStateException("The list is empty and there is no item to remove");
        }
        Node current = head;
        Node previous = head;
        for (int i = 1; i < position && current != null; i++) {
            previous = current;
            // current = current.next;
            current = current.getNextNode();
        }
        T removedItem = current.getNodeItem();
        // previous.next = current.next;
        previous.setNextNode(current.getNextNode());
        size--;
        return removedItem;

    }

    // Method to get an item from the list
    public T get(int position) {
        // Check if the list is empty
        if (head == null) {
            throw new IllegalStateException("Could not get the item, the list is empty");
        }
        Node current = head;
        for (int i = 0; i < size() && current != null; i++) {
            if (i == position) {
                return current.getNodeItem();
            }
            // current = current.next;
            current = current.getNextNode();
        }
        // for (int i = 1; i < position && current != null; i++) {
        // // current = current.next;
        // current = current.getNextNode();
        // }
        // T item = current.getNodeItem();
        // return item;
        // if the item is not found return null
        return null;
    }

    // Method to search for an item in the list

    public int contains(T item) {
        // Check if the list is empty
        if (head == null) {
            throw new IllegalStateException("The list is empty");
        }
        Node current = head;
        for (int i = 0; i < size() && current != null; i++) {
            if (current.getNodeItem().equals(item)) {
                return i;
            }
            // current = current.next;
            current = current.getNextNode();
        }
        // if the list does not contain the item, return -1
        return -1;
    }

    // Method to get size of the list
    public int size() {
        return size;
    }

    // Override the toString() method to stringyfy linkedlist items
    @Override
    public String toString() {
        StringBuffer listContent = new StringBuffer();
        Node current = head;
        while (current != null) {
            listContent.append(current.getNodeItem());
            // current = current.next;
            current = current.getNextNode();
            if (current != null) {
                listContent.append(", ");
            }
        }
        return listContent.toString();
    }

    // Node class for linkedlist's node
    private class Node {
        private T data;
        private Node next;

        // Constructor to create a node
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        // Method to get next node of the list
        public Node getNextNode() {
            return this.next;
        }

        // Method to get next item of the list
        public T getNodeItem() {
            return this.data;
        }

        // Method to set next node of the list
        public void setNextNode(Node next) {
            this.next = next;
        }
    }
}