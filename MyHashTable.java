public class MyHashTable<K, V> {
    private final HashNode[] buckets;
    private final int capacity;
    private int size;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new HashNode[this.capacity];
        this.size = 0;
    }

    private static class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = (K) key;
            this.value = (V) value;
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

    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("key or value is null");
        }
        int bucketIndex = hash((Integer) key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode((Integer) key, (String) value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    private int hash(Integer key) {
        return key % capacity; //или же bucket.length
    }

    public V get(Integer key) {
        int bucketIndex = hash(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return (V) head.value;
            }
            head = head.next;
        }
        return (V) buckets[bucketIndex].value;
    }

    public V remove(Integer key) {
        if(key == null) {
            throw new IllegalArgumentException("key is null");
        }

        int bucketIndex = hash(key);
        HashNode head = buckets[bucketIndex];
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
        if(prev != null){
            prev.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }
        return (V) head.value;
    }
}

