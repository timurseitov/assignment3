public class MyHashTable {
    private HashNode[] buckets;
    private int capacity; //(capacity)
    private int size;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new HashNode[this.capacity];
        this.size = 0;
    }

    private class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
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

    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("key or value is null");
        }
        int bucketIndex = toIndex(key); //переиммноватть
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
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    private int toIndex(Integer key) {
        return key % capacity; //или же bucket.length
    }

    public String get(Integer key) {
        int bucketIndex = toIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return buckets[bucketIndex].value;
    }

    public String remove(Integer key) {
        if(key == null) {
            throw new IllegalArgumentException("key is null");
        }

        int bucketIndex = toIndex(key);
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
        return head.value;
    }
}
