// Tree DFS: recurse, combine children's answers (post-order) or pass state down (pre-order).
// e.g. lowest common ancestor
TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null || node == p || node == q) return node;   // base case
    TreeNode left = lca(node.left, p, q);
    TreeNode right = lca(node.right, p, q);
    if (left != null && right != null) return node;            // p and q on different sides
    return left != null ? left : right;
}
// Return-one-thing-track-another (max path sum, diameter): the helper returns the best single
// downward path, and updates a field with the best path through the node (left + right + node).
// Validate BST: pass (low, high) bounds down; use long or Integer nulls for the sentinels.
