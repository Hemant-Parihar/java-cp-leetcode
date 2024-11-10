class Solution {
    int ans = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] inDegree = new int[n];

        for(int i = 0; i < n; i++) {
            int u = i;
            int v = edges[i];
            if (v != -1)
                inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int u = queue.remove();
            int v = edges[u];
            if (v != -1) {
                edges[u] = -1;
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // System.out.println(Arrays.toString(edges));

        for(int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                dfs(i, edges, 0);
                // ans = Math.max(len, ans);
            }
        }

        return ans;
    }

    void dfs(int i, int[] graph, int len) {
        if (graph[i] == -2) {
            ans = Math.max(ans, len);
            return;
        }

        int temp = graph[i];
        graph[i] = -2;
        dfs(temp, graph, len + 1);
        graph[i] = temp;
        graph[i] = -1;
    }


}