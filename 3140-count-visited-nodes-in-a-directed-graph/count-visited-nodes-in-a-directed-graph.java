class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] ans = new int[n];

        boolean[] cycleSet = new boolean[n];

        for(int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                boolean[] visited = new boolean[n];
                int cycleNode = findCycle(i, edges, visited, cycleSet, ans);
                if (cycleSet[cycleNode] == true || ans[cycleNode] != 0) {
                    reachCycle(i, edges, ans);
                } else {
                    // Arrays.fill(visited, false);
                    // int val = dfs(cycleNode, edges, visited);
                    // for(int j = 0; j < n; j++) {
                    //     if (visited[j] == true) {
                    //         ans[j] = val;
                    //         cycleSet[j] = true;
                    //     }
                    // }
                    HashSet<Integer> visitedSet = new HashSet<>();
                    int val = dfs2(cycleNode, edges, visitedSet);
                    for(Integer num : visitedSet) {
                        ans[num] = val;
                        cycleSet[num] = true;
                    }
                    if (ans[i] == 0) {
                        reachCycle(i, edges, ans);
                    }
                }
            }
        }
        
        return ans;
    }
    
    int findCycle(int node, List<Integer> edges, boolean[] visited, boolean[] cycleSet, int[] ans) {
        if (visited[node] == true || cycleSet[node] == true || ans[node] != 0) return node;
        visited[node] = true;
        return findCycle(edges.get(node), edges, visited, cycleSet, ans);
    }
    
    int dfs(int node, List<Integer> edges, boolean[] visited) {
        if (visited[node] == true) return 0;
        visited[node] = true;
        return 1 + dfs(edges.get(node), edges, visited);
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