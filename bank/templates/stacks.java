// Stacks: push openers / pending items, pop when the matching closer or a resolving item arrives.
Deque<Character> stack = new ArrayDeque<>();
Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
for (char c : s.toCharArray()) {
    if (pairs.containsKey(c)) {
        if (stack.isEmpty() || stack.pop() != pairs.get(c)) return false;
    } else stack.push(c);
}
return stack.isEmpty();
// Monotonic stack (next warmer day): stack of indices with decreasing values;
// while (!st.isEmpty() && t[i] > t[st.peek()]) { int j = st.pop(); ans[j] = i - j; } st.push(i);
