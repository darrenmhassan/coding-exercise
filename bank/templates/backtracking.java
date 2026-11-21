// Backtracking: choose, explore, un-choose. Prune as early as possible.
List<List<Integer>> res = new ArrayList<>();
void backtrack(int start, int remaining, Deque<Integer> path) {
    if (remaining == 0) { res.add(new ArrayList<>(path)); return; }   // complete solution
    for (int i = start; i < candidates.length; i++) {
        if (candidates[i] > remaining) continue;                      // prune
        path.addLast(candidates[i]);                                  // choose
        backtrack(i, remaining - candidates[i], path);               // explore (i: reuse allowed)
        path.removeLast();                                            // un-choose
    }
}
// Grid word search: mark cell visited (board[r][c] = '#'), recurse to 4 neighbours, restore the cell.
