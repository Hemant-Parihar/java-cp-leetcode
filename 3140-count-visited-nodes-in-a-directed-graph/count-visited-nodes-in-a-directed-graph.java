class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                boolean[] visited = new boolean[n];
                int cycleNode = findCycle(i, edges, visited, ans);
                if (ans[cycleNode] != 0) {
                    reachCycle(i, edges, ans);
                } else {
                    HashSet<Integer> visitedSet = new HashSet<>();
                    int val = dfs2(cycleNode, edges, visitedSet);
                    for(Integer num : visitedSet) {
                        ans[num] = val;
                    }
                    if (ans[i] == 0) {
                        reachCycle(i, edges, ans);
                    }
                }
            }
        }
        
        return ans;
    }
    
    int findCycle(int node, List<Integer> edges, boolean[] visited, int[] ans) {
        if (visited[node] == true || ans[node] != 0) return node;
        visited[node] = true;
        return findCycle(edges.get(node), edges, visited, ans);
    }

    int dfs2(int node, List<Integer> edges, HashSet<Integer> visitedSet) {
        if (visitedSet.contains(node)) return 0;
        visitedSet.add(node);
        return 1 + dfs2(edges.get(node), edges, visitedSet);
    }
    
    int reachCycle(int node, List<Integer> edges, int[] ans) {
        if (ans[node] != 0) return ans[node];
        return ans[node] = 1 + reachCycle(edges.get(node), edges, ans);
    }
    
    
}