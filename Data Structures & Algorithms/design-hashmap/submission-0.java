class MyHashMap {
    private static class Pair {
        int key;
        int value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private LinkedList<Pair>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        for (Pair pair : buckets[index]) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        buckets[index].addFirst(new Pair(key, value));
    }
    
    public int get(int key) {
        int index = hash(key);
        for (Pair pair : buckets[index]) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        for (Pair pair : buckets[index]) {
            if (pair.key == key) {
                buckets[index].remove(pair);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % BASE;
    }
}