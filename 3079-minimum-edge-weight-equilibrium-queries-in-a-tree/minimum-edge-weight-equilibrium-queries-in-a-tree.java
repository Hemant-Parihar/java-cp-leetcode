class Solution {

    int MAX_ROW = 17;

    void dfs(int node, int depth, int[] count, int[] level, HashMap<Integer, int[]> map,
                    ArrayList[] adj, int[] p, boolean[] v) {

        level[node] = depth;
        int[] ans = new int[27];
        for(int i = 1; i < 27; i++) {
            ans[i] = count[i];
        }
        map.put(node, ans);

        for(int i = 0; i < adj[node].size(); i++) {
            int[] arr = (int[]) adj[node].get(i);
            if (v[arr[0]] == false) {
                p[arr[0]] = node;
                v[arr[0]] = true;
                count[arr[1]]++;
                dfs(arr[0], depth + 1, count, level, map, adj, p, v);
                count[arr[1]]--;
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


    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
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

        int[] level = new int[n];
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] p = new int[n];
        boolean[] v = new boolean[n];

        v[0] = true;
        dfs(0, 0, new int[27], level, map, adj, p, v);

        int[][] table = new int[MAX_ROW][n];
        build(p, table);

        int[] ans = new int[m];

        for(int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            
            // System.out.println(lcs(a, b, table, level));
            // System.out.println(lcs(b, c, table, level));
            // System.out.println(lcs(c, a, table, level));

            int node = lcs(a, b, table, level);

            int[] ac = map.get(a);
            int[] bc = map.get(b);

            int[] nodec = map.get(node);

            int temp = 0;
            int max = 0;
            for(int j = 1; j < 27; j++) {
                int val = (ac[j] + bc[j] - 2*nodec[j]);
                max = Math.max(max, val);
                temp += val;
            }

            ans[i] = temp - max;
        }

        return ans;



    }
}