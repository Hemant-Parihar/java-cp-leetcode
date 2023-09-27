class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Pair<Integer, Integer>>();
        }
        for(int i = 0; i < flights.length; i++) {
            adjList[flights[i][0]].add(new Pair(flights[i][1], flights[i][2]));
        }

        // System.out.println(Arrays.toString(adjList));

        int[][] visited = new int[n][k + 2];
        for(int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b) -> a[2] - b[2]);
        heap.add(new int[]{src, 0, k + 1});
        visited[src][k + 1] = 0;

        while(!heap.isEmpty()) {
            int[] arr = heap.poll();
            int start = arr[0];
            int cost = arr[1];
            int step = arr[2];

            if (step == 0 || start == dst) {
                continue;
            }

            step--;
            for(int i = 0; i < adjList[start].size(); i++) {
                Pair<Integer, Integer> pair = (Pair<Integer, Integer>)adjList[start].get(i);
                int end = pair.getKey();
                int dis = pair.getValue();
                if (visited[end][step] > dis + cost) {
                    visited[end][step] = dis + cost;
                    heap.add(new int[]{end, dis + cost, step});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= k + 1; i++) {
            ans = Math.min(ans, visited[dst][i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}