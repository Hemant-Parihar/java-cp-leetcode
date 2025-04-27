class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int[] inDegree = new int[n];

        for(int i = 0; i < pre.length; i++) {
            int a = pre[i][0];
            int b = pre[i][1];
            graph[b].add(a);
            inDegree[a]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // boolean v[] = new boolean[n];

        for(int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                // v[i] = true;
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {

            int node = queue.poll();
            count++;

            for(int i = 0; i < graph[node].size(); i++) {
                int newNode = (int) graph[node].get(i);
                inDegree[newNode]--;
                if (inDegree[newNode] == 0) {
                    queue.add(newNode);
                }
            }


        }

        if (count == n) return true;
        return false;
    }
}