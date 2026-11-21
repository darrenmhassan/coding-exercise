// Sliding Window (variable size): grow right, shrink left while the window is invalid. O(n).
// e.g. longest substring without repeating characters
Map<Character, Integer> count = new HashMap<>();
int left = 0, best = 0;
for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);
    count.merge(c, 1, Integer::sum);            // add right element to the window
    while (count.get(c) > 1) {                  // window invalid: shrink from the left
        char d = s.charAt(left++);
        count.merge(d, -1, Integer::sum);
    }
    best = Math.max(best, right - left + 1);    // window valid: update answer
}
return best;
// Fixed size k: add nums[right], and once right >= k-1 record the answer, then remove nums[right-k+1].
