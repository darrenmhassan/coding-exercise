// Modified Binary Search: find the first index where a monotonic condition becomes true.
int lo = 0, hi = n;                  // answer lies in [lo, hi]
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;    // avoids overflow
    if (condition(mid)) hi = mid;    // mid could be the answer: keep it
    else lo = mid + 1;               // mid is too small: discard it
}
return lo;
// Rotated array: one half of [lo, mid, hi] is always sorted; check if target lies in that half.
// Search on the answer (min capacity/speed): lo..hi are candidate answers, condition = "feasible(mid)".
