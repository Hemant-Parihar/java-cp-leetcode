class Solution {
    
    class Node {
        int v;
        int w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            graph[u].add( new Node(v, w) );
        }

        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> a.w - b.w );

        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);

        pq.add(new Node(k, 0));
        ans[k] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.v;
            for(int i = 0; i < graph[u].size(); i++) {
                Node newNode = (Node) graph[u].get(i);
                int w = node.w + newNode.w;
                // System.out.println(w + " " + newNode.v + " " + ans[newNode.v]);
                if (w < ans[newNode.v]) {
                    ans[newNode.v] = w;
                    pq.add(new Node(newNode.v, w));
                }
            }
        }

        int ret = -1;
        for(int i = 1; i <= n; i++) {
            ret = Math.max(ret, ans[i]);
        }

        System.out.println(Arrays.toString(ans));

        if (ret == Integer.MAX_VALUE) return -1;
        return ret;
    }
}