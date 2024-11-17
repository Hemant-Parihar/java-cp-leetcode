class Solution {
    class Edge {
        int v;
        int w;
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    class Node{
        int u;
        int cost;
        int len;
        Node(int u, int cost, int len) {
            this.u = u;
            this.cost = cost;
            this.len = len;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            graph[u].add(new Edge(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> a.len - b.len );

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        ans[src] = 0;
        pq.add(new Node(src, 0, 0));

        while( !pq.isEmpty() ) {

            Node node = pq.poll();
            int u = node.u;

            if (node.len == k + 1) continue;
            
            for(int i = 0; i < graph[u].size(); i++) {
                Edge edge = (Edge) graph[u].get(i);
                if ( (node.cost + edge.w) < ans[edge.v] ) {
                    ans[edge.v] = node.cost + edge.w;
                    pq.add( new Node(edge.v, node.cost + edge.w, node.len + 1) );
                }
            }

        }

        System.out.println(Arrays.toString(ans));

        if (ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}