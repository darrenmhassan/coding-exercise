// Top K Elements: keep a heap of size k whose root is the WORST of the current top k. O(n log k).
// e.g. k most frequent
Map<Integer, Integer> freq = new HashMap<>();
for (int x : nums) freq.merge(x, 1, Integer::sum);
PriorityQueue<Map.Entry<Integer, Integer>> heap =
    new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue())); // min heap by freq
for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
    heap.offer(e);
    if (heap.size() > k) heap.poll();        // evict the least frequent
}
int[] res = new int[k];
for (int i = k - 1; i >= 0; i--) res[i] = heap.poll().getKey();
return res;
// Largest k -> min heap; smallest k (closest points) -> max heap. Ties: add a second comparator key.
