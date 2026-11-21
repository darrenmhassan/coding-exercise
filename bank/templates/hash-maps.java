// Hash Maps: trade space for O(1) lookups. Ask "what have I already seen that completes this?"
// e.g. two sum
Map<Integer, Integer> indexOf = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    Integer j = indexOf.get(target - nums[i]);      // the complement seen earlier?
    if (j != null) return new int[]{j, i};
    indexOf.put(nums[i], i);
}
return new int[0];
// Grouping: map.computeIfAbsent(key, k -> new ArrayList<>()).add(item), e.g. key = sorted letters.
