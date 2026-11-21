// Graphs: BFS for shortest path in unweighted graphs / grids, DFS for connectivity. O(V + E).
// e.g. grid BFS (multi-source: enqueue every start cell first, as in rotting oranges)
int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
Deque<int[]> queue = new ArrayDeque<>();
boolean[][] seen = new boolean[rows][cols];
queue.offer(new int[]{sr, sc}); seen[sr][sc] = true;
int steps = 0;
while (!queue.isEmpty()) {
    for (int size = queue.size(); size > 0; size--) {       // one BFS level = one step
        int[] cur = queue.poll();
        if (isTarget(cur)) return steps;
        for (int[] d : DIRS) {
            int r = cur[0] + d[0], c = cur[1] + d[1];
            if (r < 0 || r >= rows || c < 0 || c >= cols || seen[r][c] || blocked(r, c)) continue;
            seen[r][c] = true;                                // mark when enqueued, not when polled
            queue.offer(new int[]{r, c});
        }
    }
    steps++;
}
return -1;
// Weighted edges: Dijkstra = same loop with a PriorityQueue<int[]{dist, node}>, skip stale entries.
