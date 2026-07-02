

class MyHashSet {
    private static final int BASE = 769;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public void add(int key) {
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].addFirst(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }

    private int hash(int key) {
        return key % BASE;
    }
}