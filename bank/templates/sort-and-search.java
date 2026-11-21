// Sort and Search: sorting makes relationships ordered, then binary search / two pointers answers queries.
// e.g. for each query, how many prefix elements fit within a budget
Arrays.sort(nums);
long[] prefix = new long[nums.length + 1];
for (int i = 0; i < nums.length; i++) prefix[i + 1] = prefix[i] + nums[i];
int[] ans = new int[queries.length];
for (int q = 0; q < queries.length; q++) {
    int lo = 0, hi = nums.length;                 // largest k with prefix[k] <= query
    while (lo < hi) {
        int mid = (lo + hi + 1) / 2;
        if (prefix[mid] <= queries[q]) lo = mid; else hi = mid - 1;
    }
    ans[q] = lo;
}
// Custom sort keys (log files, envelopes) are often the whole trick: write the comparator carefully.
