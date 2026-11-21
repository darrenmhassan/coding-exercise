// Topological Sort (Kahn): count in-degrees, start from nodes with none, peel layer by layer.
List<List<Integer>> graph = new ArrayList<>();
int[] indegree = new int[n];
for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
for (int[] e : prerequisites) { graph.get(e[1]).add(e[0]); indegree[e[0]]++; }  // e[1] before e[0]

Deque<Integer> queue = new ArrayDeque<>();
for (int i = 0; i < n; i++) if (indegree[i] == 0) queue.offer(i);
List<Integer> order = new ArrayList<>();
while (!queue.isEmpty()) {
    int u = queue.poll();
    order.add(u);
    for (int v : graph.get(u)) if (--indegree[v] == 0) queue.offer(v);
}
return order.size() == n ? order : List.of();    // fewer than n => cycle
