class Solution {

    class Node {
        int des;
        int w;
        Node(int des, int w) {
            this.des = des;
            this.w = w;
        }
    }

    public int minScore(int n, int[][] roads) {
        ArrayList[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        Queue<Node> queue = new LinkedList<>();
        int[] v = new int[n + 1];
        Arrays.fill(v, Integer.MAX_VALUE);

        queue.add(new Node(1, Integer.MAX_VALUE));
        int ans = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.des == n) {
                ans = Math.min(ans, node.w);
            }

            for(int i = 0; i < graph[node.des].size(); i++) {
                Node target = (Node) graph[node.des].get(i);
                int temp_ans = Math.min(node.w, target.w);
                if (v[target.des] > temp_ans ) {
                    v[target.des] = temp_ans;
                    queue.add( new Node(target.des, temp_ans ));
                }
            }
        }

        return ans;
    }
}