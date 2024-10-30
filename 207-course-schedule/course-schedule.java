class Solution {
    public boolean canFinish(int n, int[][] arr) {
        ArrayList[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int[] inDegree = new int[n];

        for(int i = 0; i < arr.length; i++) {
            int b = arr[i][1];
            int a = arr[i][0];
            inDegree[a]++;
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.remove();
            for(int i = 0; i < graph[node].size(); i++) {
                int a = (int) graph[node].get(i);
                inDegree[a]--;
                if (inDegree[a] == 0) {
                    queue.add(a);
                    visited[a] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if (visited[i] == false) return false;
        }
        return true;
    }
}