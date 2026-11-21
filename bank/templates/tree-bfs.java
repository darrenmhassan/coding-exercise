// Tree BFS: queue, process one level at a time using the queue size.
List<List<Integer>> levels = new ArrayList<>();
if (root == null) return levels;
Deque<TreeNode> queue = new ArrayDeque<>();
queue.offer(root);
while (!queue.isEmpty()) {
    List<Integer> level = new ArrayList<>();
    for (int size = queue.size(); size > 0; size--) {
        TreeNode n = queue.poll();
        level.add(n.val);
        if (n.left != null) queue.offer(n.left);
        if (n.right != null) queue.offer(n.right);
    }
    levels.add(level);                 // zigzag: reverse on odd levels; right view: last element
}
return levels;
