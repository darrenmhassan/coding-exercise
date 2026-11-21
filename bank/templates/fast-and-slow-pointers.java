// Fast and Slow Pointers: fast moves 2, slow moves 1. They meet iff there is a cycle.
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) {                 // cycle found; find its start (Floyd):
        ListNode p = head;
        while (p != slow) { p = p.next; slow = slow.next; }
        return p;
    }
}
return null;                             // no cycle; when fast ends, slow is at the middle
