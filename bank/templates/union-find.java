// Union Find: parent array with path compression and union by rank. Near O(1) per op.
int[] parent, rank;
UnionFind(int n) {
    parent = new int[n]; rank = new int[n];
    for (int i = 0; i < n; i++) parent[i] = i;
}
int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]);   // path compression
    return parent[x];
}
boolean union(int a, int b) {                           // false if already connected (=> cycle)
    int ra = find(a), rb = find(b);
    if (ra == rb) return false;
    if (rank[ra] < rank[rb]) { int t = ra; ra = rb; rb = t; }
    parent[rb] = ra;
    if (rank[ra] == rank[rb]) rank[ra]++;
    return true;
}
// Components = n minus successful unions. Non-integer keys (emails): map each to an index first.
