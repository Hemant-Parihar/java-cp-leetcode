class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList[] adjList = new ArrayList[n+1];
        int[] inDegree = new int[n+1];
        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < relations.length; i++) {
            adjList[relations[i][0]].add(relations[i][1]);
            inDegree[relations[i][1]]++;
        }

        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        int maxTime = 0;
        for(int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                heap.add(new Pair(i, 0 + time[i-1]));
            }
        }

        while(!heap.isEmpty()) {
            Pair<Integer, Integer> pair = heap.poll();
            int node = pair.getKey();
            int curr_time = pair.getValue();
            maxTime = Math.max(maxTime, curr_time);
            
            for(int j = 0; j < adjList[node].size(); j++) {
                int val = (int)adjList[node].get(j);
                if (inDegree[val] == 1) {
                    heap.add(new Pair(val, curr_time + time[val - 1]));
                }
                inDegree[val]--;
            }
        }

        return maxTime;
    }
}