class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList[] arr = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
            if (i != n - 1)
                arr[i].add(i + 1);
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            arr[u].add(v);
            ans[i] = bfs(arr);
        }

        return ans;
    }

    int bfs(ArrayList[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int n = arr.length;
        boolean[] v = new boolean[n];
        v[0] = true;

        int level = 0;
        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int node = queue.poll();
                
                for(int j = 0; j < arr[node].size(); j++) {
                    int z = (int) arr[node].get(j);
                    if (z == n - 1) return level + 1;
                    if (v[z] == false) {
                        v[z] = true;
                        queue.add(z);
                    }
                }
            }

            level++;
        }

        return level;
    }
}