// Custom Data Structures: combine structures so every op is O(1). e.g. LRU cache = map + doubly linked list.
class LRUCache {
    class Node { int key, val; Node prev, next; Node(int k, int v) { key = k; val = v; } }
    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0), tail = new Node(0, 0);   // sentinels

    LRUCache(int capacity) { this.capacity = capacity; head.next = tail; tail.prev = head; }

    int get(int key) {
        Node n = map.get(key);
        if (n == null) return -1;
        remove(n); addFront(n);                 // mark most recently used
        return n.val;
    }
    void put(int key, int val) {
        Node n = map.get(key);
        if (n != null) { n.val = val; remove(n); addFront(n); return; }
        if (map.size() == capacity) { Node lru = tail.prev; remove(lru); map.remove(lru.key); }
        n = new Node(key, val); map.put(key, n); addFront(n);
    }
    private void remove(Node n) { n.prev.next = n.next; n.next.prev = n.prev; }
    private void addFront(Node n) { n.next = head.next; n.prev = head; head.next.prev = n; head.next = n; }
}
// SDE3 signal: state the invariants, name things well, mention thread safety as a follow-up.
