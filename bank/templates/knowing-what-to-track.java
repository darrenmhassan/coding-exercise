// Knowing What to Track: count first, then use the counts. Prefix sum + map counts subarrays.
// e.g. number of subarrays summing to k (works with negatives, unlike a sliding window)
Map<Integer, Integer> seenPrefix = new HashMap<>();
seenPrefix.put(0, 1);                         // empty prefix
int sum = 0, count = 0;
for (int x : nums) {
    sum += x;
    count += seenPrefix.getOrDefault(sum - k, 0);   // earlier prefixes that leave exactly k
    seenPrefix.merge(sum, 1, Integer::sum);
}
return count;
// Fixed alphabet: int[26] counts beat a HashMap; compare arrays with Arrays.equals.
