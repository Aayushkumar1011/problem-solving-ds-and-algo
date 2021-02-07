package stack;

public class Stack<T> {
    private T[] data;
    private int stackPointer;

    public Stack() {
        data = (T[]) new Object[1000];
        stackPointer = 0;
    }

    public void push(T item) {
        data[stackPointer++] = item;
    }

    public T pop() {
        if (stackPointer == 0) {
            throw new IllegalStateException("No more item in stack");
        }
        return data[--stackPointer];
    }

    public boolean contains(T item) {
        boolean found = false;
        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public T get(T item) {
        try {
            while (stackPointer > 0) {
                T temp = pop();
                if (item.equals(temp)) {
                    return temp;
                }
            }
            throw new IllegalArgumentException("Could not find item on stack " + item);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public T getItem(T item) {
        if (contains(item)) {
            return item;
        }

        throw new IllegalArgumentException("Could not find item on stack " + item);
    }

    public int size() {
        return stackPointer;
    }

}
