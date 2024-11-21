class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        int[] alice_p = new int[n + 1];
        int[] alice_r = new int[n + 1];

        int[] bob_p = new int[n + 1];
        int[] bob_r = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            alice_p[i] = i;
            bob_p[i] = i;
            alice_r[i] = 1;
            bob_r[i] = 1;
        }

        int ans = 0;

        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        for(int i = 0; i < edges.length; i++) {
            int t = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];

            if (t == 1) {
                int parent_u = find(u, alice_p);
                int parent_v = find(v, alice_p);
                if (parent_u != parent_v) {
                    union(u, v, alice_p, alice_r);
                } else {
                    ans++;
                }
            } else if (t == 2) {
                int parent_u = find(u, bob_p);
                int parent_v = find(v, bob_p);
                if (parent_u != parent_v) {
                    union(u, v, bob_p, bob_r);
                } else {
                    ans++;
                }
            } else{
                int parent_u = find(u, alice_p);
                int parent_v = find(v, alice_p);
                if (parent_u != parent_v) {
                    union(u, v, alice_p, alice_r);
                    union(u, v, bob_p, bob_r);
                } else {
                    ans++;
                }
            }
        }


        int parent = find(1, alice_p);

        for(int i = 2; i <= n; i++) {
            if (find(i, alice_p)  != parent) return -1;
        }

        parent = find(1, bob_p);
        for(int i = 2; i <=n; i++) {
            if (find(i, bob_p) != parent) return -1;
        }

        return ans;
    }

    int find(int i, int[] parent) {
        while(i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    void union(int u, int v, int[] parent, int[] rank) {
        int parent_u = find(u, parent);
        int parent_v = find(v, parent);

        if (parent_u != parent_v) {
            if (rank[parent_u] >= rank[parent_v]) {
                parent[parent_v] = parent_u;
                rank[parent_u] = rank[parent_u] + rank[parent_v];
            } else {
                parent[parent_u] = parent_v;
                rank[parent_v] = rank[parent_u] + rank[parent_v];
            }
        }
    }
}