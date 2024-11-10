class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outDegree = new int[n];
        int[] inDegree = new int[n];

        ArrayList[] invG = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            invG[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                outDegree[i]++;
                int node = graph[i][j];
                inDegree[j]++;
                invG[node].add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while( !queue.isEmpty() ) {
            int node = queue.remove();

            ans.add(node);

            for(int i = 0; i < invG[node].size(); i++) {
                int newNode = (int) invG[node].get(i);
                outDegree[newNode]--;
                if (outDegree[newNode] == 0) {
                    queue.add(newNode);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}