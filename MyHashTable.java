public class MyHashTable<K, V> {
    private final HashNode[] arr;
    private final int capacity;
    private int size;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.arr = new HashNode[this.capacity];
        this.size = 0;
    }

    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(V value) {
        HashNode head;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].value.equals(value)) {
                return true;
            }

        }
        return false;
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("key or value is null");
        }
        int Index = hash(key);
        HashNode head = arr[Index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = arr[Index];
        HashNode node = new HashNode(key, value);
        node.next = head;
        arr[Index] = node;
    }

    private int hash(K key) {
        return (Integer) key % capacity; //или же arr.length
    }

    public V get(K key) {
        int Index = hash(key);
        HashNode head = arr[Index];
        while (head != null) {
            if (head.key.equals(key)) {
                return (V) head.value;
            }
            head = head.next;
        }
        return (V) arr[Index].value;
    }

    public V remove(K key) {
        if(key == null) {
            throw new IllegalArgumentException("key is null");
        }

        int Index = hash(key);
        HashNode head = arr[Index];
        HashNode prev = null;

        while(head != null) {
            if(head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null) {
            return null;
        }
        size--;
        if(prev != null) {
            prev.next = head.next;
        } else {
            arr[Index] = head.next;
        }
        return (V) head.value;
    }
}


