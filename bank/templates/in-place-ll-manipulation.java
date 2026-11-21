// In-place LL Manipulation: reverse with prev / curr / next. O(n) time, O(1) space.
ListNode prev = null, curr = head;
while (curr != null) {
    ListNode next = curr.next;   // save
    curr.next = prev;            // reverse the link
    prev = curr;                 // advance
    curr = next;
}
return prev;                     // new head
// Sublist (left..right): use a dummy node, walk to the node before `left`, reverse right-left+1 nodes,
// then reconnect both ends. A dummy head avoids special-casing the first node.
