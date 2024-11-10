class Solution {
    int ans = 0;
    public int minReorder(int n, int[][] conn) {
        ArrayList[] graph = new ArrayList[n];
        ArrayList[] invertedGraph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            invertedGraph[i] = new ArrayList<>();
        }

        for(int i = 0; i < conn.length; i++) {
            int u = conn[i][0];
            int v = conn[i][1];

            graph[u].add(v);
            invertedGraph[v].add(u);
        }

        // for(int i = 0; i < n; i++) {
        //     System.out.println(graph[i]);
        // }

        // System.out.println("===============================");

        // for(int i = 0; i < n; i++) {
        //     System.out.println(invertedGraph[i]);
        // }

        boolean[] v = new boolean[n];

        dfs(0, graph, invertedGraph, v);

        // System.out.println(Arrays.toString(v));
        return ans;
    }

    void dfs(int i, ArrayList[] graph, ArrayList[] invertedGraph, boolean[] v) {

        v[i] = true;
        for(int k = 0; k < graph[i].size(); k++) {
            int node = (int)graph[i].get(k);
            if (v[node] == false) {
                ans++;
                // System.out.println(node);
                v[node] = true;
                dfs(node, graph, invertedGraph, v);
            }
        }

        for(int k = 0; k < invertedGraph[i].size(); k++) {
            int node = (int)invertedGraph[i].get(k);
            if (v[node] == false) {
                v[node] = true;
                dfs(node, graph, invertedGraph, v);
            }
        }
    }
}