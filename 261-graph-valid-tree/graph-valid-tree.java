class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (findParent(u, parent) == findParent(v, parent)) {
                return false;
            } else {
                union(u, v, parent, rank);
            }
        }

        return true;
    }

    void union(int u, int v, int[] parent, int[] rank) {
        int parent_u = findParent(u, parent);
        int parent_v = findParent(v, parent);

        if (parent_u != parent_v) {
            if (rank[parent_u] >= rank[parent_v]) {
                rank[parent_u] = rank[parent_u] + rank[parent_v];
                parent[parent_v] = parent_u;
            } else {
                parent[parent_u] = parent_v;
                rank[parent_v] = rank[parent_u] + rank[parent_v];
            }
        }
    }

    int findParent(int i, int[] parent) {
        while(i != parent[i]) {
            i = parent[i];
        }
        return i;
    }
}