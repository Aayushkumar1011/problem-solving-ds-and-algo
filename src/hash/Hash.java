package hash;

public class Hash<X, Y> {
    private HashEntry[] data;
    private int capacity;
    public int size;

    public Hash(int capacity) {
        this.capacity = capacity;
        this.data = new HashEntry[this.capacity];
        this.size = 0;

    }

    public int size() {
        return this.size;
    }

    public Y get(X key) {
        // Get the hash code(hash key or index) for the given key
        int hash = hashKey(key);
        // Check if there is no data for the given key
        if (data[hash] == null) {
            return null;
        }
        // Otherwise get the hash code for the key and return its value
        else {
            return (Y) data[hash].getValue();
        }
    }

    public void put(X key, Y value) {
        // Get the hash code(hash key or index) for the given key
        int hash = hashKey(key);
        // data[hash].setValue(value);
        // data[hash] = new HashEntry<>(key, value);
        data[hash] = new HashEntry<X, Y>(key, value);
        size++;
    }

    public int hashKey(X key) {
        int hash = (key.hashCode() % this.capacity);
        // Check if hash is empty or the key is already present to avoid collision
        if (data[hash] != null && !data[hash].getKey().equals(key)) {
            hash = (hash + 1) % this.capacity;
        }
        return hash;
    }

    private class HashEntry<X, Y> {
        private X key;
        private Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }

    }

}
