// Merge Intervals: sort by start, then compare each interval with the last merged one.
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
List<int[]> merged = new ArrayList<>();
for (int[] cur : intervals) {
    int[] last = merged.isEmpty() ? null : merged.get(merged.size() - 1);
    if (last == null || cur[0] > last[1]) merged.add(cur);   // gap: start new interval
    else last[1] = Math.max(last[1], cur[1]);                // overlap: extend
}
return merged.toArray(new int[0][]);
// "Max overlapping at once" (rooms, bitrate): sort starts and ends separately, or sweep +1/-1 events.
