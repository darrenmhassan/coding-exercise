// Heaps: two heaps for a running median. add O(log n), median O(1).
PriorityQueue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder()); // max heap: smaller half
PriorityQueue<Integer> high = new PriorityQueue<>();                         // min heap: larger half

void add(int x) {
    low.offer(x);
    high.offer(low.poll());                      // keep every low <= every high
    if (high.size() > low.size()) low.offer(high.poll());  // low may hold one extra
}
double median() {
    return low.size() > high.size() ? low.peek() : (low.peek() + high.peek()) / 2.0;
}
// Scheduling flavour: heap of (nextFreeTime, ...) and repeatedly poll the earliest.
