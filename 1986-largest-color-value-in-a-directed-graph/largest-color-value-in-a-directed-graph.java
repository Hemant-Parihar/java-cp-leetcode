class Solution {
    
    HashMap<Integer, int[]> map = new HashMap<>();
    boolean loop = false;

    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();
        ArrayList[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (u == v) return -1;
            graph[u].add(v);
        }

        int ans = 1;

        boolean[] v = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (v[i] == false) {
                int[] temp_ans = dfs(i, graph, colors, v);
                if (loop == true) return -1;
                for(int k = 0; k < 26; k++) {
                    ans = Math.max(ans, temp_ans[k]);
                }
            }
        }

        return ans;
    }

    int[] dfs(int i, ArrayList[] graph, String colors, boolean[] v) {
        if (v[i] == true && map.containsKey(i) == false) {
            loop = true;
            return new int[26];
        }

        if (map.containsKey(i) == true) {
            return map.get(i);
        }

        v[i] = true;
        char ch = colors.charAt(i);

        int[] temp_ans = new int[26];

        for(int u = 0; u < graph[i].size(); u++) {
            int[] val = dfs( (int) graph[i].get(u), graph, colors, v);
            if (loop == true) return temp_ans;
            for(int k = 0; k < 26; k++) {
                temp_ans[k] = Math.max(val[k], temp_ans[k]);
            }
        }
        
        temp_ans[ch - 'a']++;

        map.put(i, temp_ans);
        return temp_ans;
    }
}