// K-way Merge: min heap of the current head of each list. O(N log k).
PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
for (ListNode n : lists) if (n != null) pq.offer(n);
ListNode dummy = new ListNode(0), tail = dummy;
while (!pq.isEmpty()) {
    ListNode n = pq.poll();          // smallest head overall
    tail.next = n; tail = n;
    if (n.next != null) pq.offer(n.next);   // replace it with the next from the same list
}
return dummy.next;
// Arrays/matrix rows: push int[]{value, listIndex, elementIndex} instead of nodes.
