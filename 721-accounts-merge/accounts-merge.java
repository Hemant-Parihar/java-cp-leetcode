class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, Integer> map = new HashMap<>();
        int n = accounts.size();

        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);

            for(int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (map.containsKey(email)) {
                    union(map.get(email), i, parent, rank);
                } else {
                    map.put(email, findParent(i, parent));
                }
            }
        }

        System.out.println(Arrays.toString(parent));

        HashMap<Integer, HashSet<String>> ansMap = new HashMap<>();
        HashMap<Integer, String> nameMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int key = findParent(i, parent);
            if (ansMap.containsKey(key)) {
                HashSet<String> set = ansMap.get(key);

                List<String> emails = accounts.get(i);
                for(int j = 1; j < emails.size(); j++) {
                    set.add(emails.get(j));
                }
            } else {
                List<String> emails = accounts.get(i);
                nameMap.put(key, emails.get(0));
                HashSet<String> set = new HashSet<>();
                for(int j = 1; j < emails.size(); j++) {
                    set.add(emails.get(j));
                }
                ansMap.put(key, set);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<Integer, String> entry : nameMap.entrySet()) {
            int key = entry.getKey();
            List<String> list = new ArrayList<>();
            list.add(entry.getValue());
            
            HashSet<String> set = ansMap.get(key);
            list.addAll(set);

            ans.add(list);
        }

        for(int i = 0; i < ans.size(); i++) {
            List<String> list = ans.get(i);
            List<String> subList = list.subList(1, list.size());
            Collections.sort(subList);
        }

        

        return ans;
    }

    void union(int u, int v, int[] parent, int[] rank) {
        int root_u = findParent(u, parent);
        int root_v = findParent(v, parent);
        
        if (root_u == root_v) {
            //rank[root_u] = rank[root_u] + rank[root_v];
            return;
        } else {
            if (rank[root_u] >= rank[root_v]) {
                parent[root_v] = parent[root_u];
                rank[root_u] = rank[root_u] + rank[root_v];
            } else {
                parent[root_u] = parent[root_v];
                rank[root_v] = rank[root_v] + rank[root_u];
            }
        }
    }

    int findParent(int i, int[] parent) {
        while(i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

}