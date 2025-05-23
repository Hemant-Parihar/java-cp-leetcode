class Solution {

    int MAX_ROW = 17;

    void dfs(int node, int depth, int wSum, int[] level, int[] sum, ArrayList[] adj, int[] p, boolean[] v) {

        level[node] = depth;
        sum[node] = wSum;

        for(int i = 0; i < adj[node].size(); i++) {
            int[] arr = (int[]) adj[node].get(i);
            if (v[arr[0]] == false) {
                p[arr[0]] = node;
                v[arr[0]] = true;
                dfs(arr[0], depth + 1, wSum + arr[1], level, sum, adj, p, v);
            }
        }
    }

    void build(int[] p, int[][] table) {
        int n = p.length;

        for(int i = 0; i < n; i++) {
            table[0][i] = p[i];
        }

        for(int i = 1; i < MAX_ROW; i++) {
            for(int j = 0; j < n; j++) {
                table[i][j] = table[i-1][table[i-1][j]];
            }
        }
    }

    int lcs(int a, int b, int[][] table, int[] level) {
        if (level[a] > level[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int k = level[b] - level[a];
        for(int i = MAX_ROW - 1; i >= 0; i--) {
            int mask = 1 << i;
            if ( (mask & k) > 0) {
                b = table[i][b];
            }
        }

        if (a == b) return a;

        // Now both are at same level.

        for(int i = MAX_ROW - 1; i >= 0; i--) {
            int pa = table[i][a];
            int pb = table[i][b];
            if (pa != pb) {
                a = pa;
                b = pb;
            }
        }

        return table[0][b];
    }

    public int[] minimumWeight(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int m = queries.length;
        ArrayList[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<int[]>();
        }

        for(int i = 0; i < n - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < adj[i].size(); j++) {
        //         int[] arr = (int[]) adj[i].get(j);
        //         System.out.print(arr[0] + " " + arr[1] + " || ");
        //     }
        //     System.out.println();
        // }

        int[] level = new int[n];
        int[] sum = new int[n];
        int[] p = new int[n];
        boolean[] v = new boolean[n];

        v[0] = true;
        dfs(0, 0, 0, level, sum, adj, p, v);

        int[][] table = new int[MAX_ROW][n];
        build(p, table);

        int[] ans = new int[m];

        // System.out.println(Arrays.toString(level));
        // System.out.println(Arrays.toString(sum));
        // System.out.println(Arrays.toString(p));

        // for(int i = 0; i < MAX_ROW; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(table[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        for(int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int c = queries[i][2];

            // System.out.println(lcs(a, b, table, level));
            // System.out.println(lcs(b, c, table, level));
            // System.out.println(lcs(c, a, table, level));

            int ab = sum[a] + sum[b] - 2*sum[lcs(a, b, table, level)];
            int bc = sum[b] + sum[c] - 2*sum[lcs(b, c, table, level)];
            int ca = sum[c] + sum[a] - 2* sum[lcs(c, a, table, level)];

            ans[i] = (ab + bc + ca) / 2;
        }

        return ans;
    }
}