class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] v = new boolean[n];
        return dfs(source, graph, destination, v);
    }

    boolean dfs(int node, ArrayList[] graph, int des, boolean[] v) {
        if (v[node] == true) return false;

        if (node == des) return true;
        v[node] = true;

        for(int i = 0; i < graph[node].size(); i++) {
            int u = (int) graph[node].get(i);
            if (v[u] == false) {
                boolean val = dfs(u, graph, des, v);
                if (val == true) return true;
            } 
        }
        return false;
    }
}