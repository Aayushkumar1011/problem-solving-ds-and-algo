package queue;

public class PrimitiveQueue<T> {

    private int front;
    private int end;
    private T[] data;

    public PrimitiveQueue() {
        /**
         * Initialize size to 1000 by default, this will call the parameterized
         * constructor
         */
        this(1000);
    }

    public PrimitiveQueue(int size) {
        this.front = -1;
        this.end = -1;
        this.data = (T[]) new Object[size];
        // this.data = (int[])new Object[1000];
    }

    // Method to get the size of the quque
    public int size() {
        // Check if the queue is empty
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    // Method to insert an item from the queue
    public void enQueue(T item) {
        // First check if the queue is full
        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("The queue is full");
        }
        // Check to see if this is the fisrt item to be added
        else if (size() == 0) {
            front++;
            end++;
            data[end] = item;
        }
        // Otherwise add the item to the end of the queue
        else {
            end++;
            data[end] = item;
        }
    }

    // Method to delete an item from the queue
    public T deQueue() {
        T item = null;
        // Check if the queue is empty, we can not dequeue empty queue
        if (size() == 0) {
            throw new IllegalStateException("Can not dequeue from the empty queue");
        }
        // Check if it is the last item on the queue, the queue needs to get reset to
        // empty
        else if (front == end) {
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        }

        // Otherwise grab the front item of the queue and return the item and adjust the
        // front
        else {
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    // Method to check if the item exist in the queue
    public boolean contains(T item) {
        boolean found = false;
        // Check if the queue is empty
        if (size() == 0) {
            return false;
        }
        for (int i = front; i < end; i++) {
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    // Method to get an item from the queue
    public T getItem(int position) {
        // Check if the queue is empty or position is out of bound(not in between front
        // and end)
        if (size() == 0 || position < front || position > end) {
            throw new IllegalArgumentException("No item in the list or the position is greater than the size");
        }
        // Otherwise initialize an index to keep track of actual iteration
        int index = 0;
        for (int i = front; i < end; i++) {
            if (index == position) {
                return data[i];
            }
            index++;
        }
        // If no item found throw an exception
        throw new IllegalArgumentException("Could not get the queue's item at position: " + position);
    }
}
