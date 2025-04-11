class Solution {

    class Node {
        int v;
        long t;
        Node(int v, long t) {
            this.v = v;
            this.t = t;
        }
    }

    int INT_MAX = 1000000007;

    public int countPaths(int n, int[][] roads) {
        ArrayList[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int t = roads[i][2];
            graph[u].add(new Node(v, t));
            graph[v].add(new Node(u, t));
        }

        long min_time = bfs(graph, n);
        // System.out.println(min_time);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        Long[] vis = new Long[n];
        Arrays.fill(vis, Long.MAX_VALUE);
        vis[0] = 0L;
        int ans = dfs(0, 0L, min_time, graph, dp, vis);
        return ans;
    }

    int dfs(int node, long t, long min_time, ArrayList[] graph, int[] dp, Long[] vis) {
        int n = graph.length;
        if (t > min_time) return 0;

        if (node == n - 1) {
            if (t == min_time) return 1;
            return 0;
        }

        if (dp[node] != -1 && t == vis[node]) return dp[node];

        vis[node] = t;
        int ans = 0;

        for(int i = 0; i < graph[node].size(); i++) {
            Node newNode = (Node) graph[node].get(i);

            if (vis[newNode.v] >= (t + newNode.t)) {
                ans += dfs(newNode.v, t + newNode.t, min_time, graph, dp, vis);
                ans %= INT_MAX;
            }
        }

        return dp[node] = ans;    
    }

    long bfs(ArrayList[] graph, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> Long.compare(a.t, b.t));
        pq.add(new Node(0, 0L));

        long[] vis = new long[n];
        Arrays.fill(vis, Long.MAX_VALUE);

        vis[0] = 0L;
        long min_time = -1;

        while(!pq.isEmpty()) {

            Node node = pq.poll();

            if (node.v == n - 1) {
                min_time = node.t;
                break;
            } else {
                int u = node.v;
                for(int i = 0; i < graph[u].size(); i++) {
                    Node newNode = (Node) graph[u].get(i);
                    int v = newNode.v;
                    long t = node.t + newNode.t;
                    if (vis[v] > t) {
                        pq.add(new Node(v, t));
                        vis[v] = t;
                    }
                }
            }
        }

        return min_time;
    }
}