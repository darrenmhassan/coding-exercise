// Two Pointers: sorted array, pointers move toward each other. O(n) after an O(n log n) sort.
// e.g. pair summing to target (inner loop of 3Sum)
int l = 0, r = nums.length - 1;
while (l < r) {
    int sum = nums[l] + nums[r];
    if (sum == target) { /* record; skip duplicates */ l++; r--; }
    else if (sum < target) l++;   // need bigger: move left pointer right
    else r--;                     // need smaller: move right pointer left
}
// Variant (same direction): write pointer w, read pointer i, e.g. move zeros to the end
int w = 0;
for (int i = 0; i < nums.length; i++) if (nums[i] != 0) nums[w++] = nums[i];
