class Solution {
    
    class Node {
        int val;
        int time;
        Node(int v, int t) {
            this.val = v;
            this.time = t;
        }
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[] inDegree = new int[n + 1];
        for(int i = 0; i < relations.length; i++) {
            int u = relations[i][0];
            int v = relations[i][1];
            graph[u].add(v);
            inDegree[v]++;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>( (a, b) -> a.time - b.time);
        for(int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(new Node(i, time[i - 1]));
            }
        }

        int ans = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                ans = Math.max(ans, node.time);
                for(int j = 0; j < graph[node.val].size(); j++) {
                    int val = (int) graph[node.val].get(j);
                    inDegree[val]--;
                    if (inDegree[val] == 0) {
                        queue.add(new Node(val, node.time + time[val - 1]));
                    }
                }
            }
        }

        return ans;
    }
}