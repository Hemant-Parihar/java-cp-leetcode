class Solution {

    class Node {
        int des;
        int time;
        Node(int des, int time) {
            this.des = des;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList[] adjList = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<Node>();
        }
        for(int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adjList[u].add(new Node(v, w));
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.time - b.time);
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        minHeap.add(new Node(k, 0));
        visited[k] = 0;
        
        while(!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int u = node.des;
            int time = node.time;

            for(int i = 0; i < adjList[u].size(); i++) {
                Node desNode = (Node) adjList[u].get(i);
                int v = desNode.des;
                if (visited[v] <= time + desNode.time) {
                    continue;
                }
                visited[v] = time + desNode.time;
                minHeap.add(new Node(v, time + desNode.time));
            }
        }

        // System.out.println(Arrays.toString(visited));

        int max = 0;
        for(int i = 1; i <= n; i++) {
            if (visited[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, visited[i]);
        }

        return max;
    }
}