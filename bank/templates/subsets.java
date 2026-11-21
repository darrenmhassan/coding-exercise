// Subsets: start with [[]]; for each element, copy every existing subset and add the element. O(n * 2^n).
List<List<Integer>> subsets = new ArrayList<>();
subsets.add(new ArrayList<>());
for (int x : nums) {
    int size = subsets.size();
    for (int i = 0; i < size; i++) {
        List<Integer> next = new ArrayList<>(subsets.get(i));
        next.add(x);
        subsets.add(next);
    }
}
return subsets;
// Permutations / phone letters: same idea, but extend each partial result with every option.
