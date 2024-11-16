class Solution {
    class Node {
        int u;
        int v;
        int w;
        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> a.w - b.w );
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new Node(i, j, w));
            }
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int ans = 0;
        int count = 0;
        while(!pq.isEmpty() && count < (n - 1)) {
            // going to visit all the edges and going to pick the minimum one.

            Node node = pq.poll();
            int u = node.u;
            int v = node.v;

            if ( find(u, parent) != find(v, parent) ) {
                // they are disjoint.
                ans += node.w;
                count++;
                union(u, v, parent, rank);
            }
        }

        return ans;
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

    int find(int u, int[] parent) {
        while (parent[u] != u) {
            u = parent[u];
        }
        return u;
    }
}