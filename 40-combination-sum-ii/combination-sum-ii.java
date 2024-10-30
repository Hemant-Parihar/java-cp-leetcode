class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] can, int target) {
        int sum = 0;
        Arrays.sort(can);
        for(int i = 0; i < can.length; i++) {
            sum += can[i];
        }
        if (sum < target) return new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < can.length; i++) {
            if (map.containsKey(can[i])) {
                map.put(can[i], map.get(can[i]) + 1);
            } else {
                map.put(can[i], 1);
            }
        }

        int n = can.length;
        int[][] dp = new int[n][target + 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        solve(0, can, map, target, new ArrayList<>(), dp);
        return ans;
    }

    int solve(int i, int[] can, HashMap<Integer, Integer> map, int target, List<Integer> list, int[][] dp) {
        
        // System.out.println(list + " " + i);

        if (target == 0) {
            ans.add(list);
            return 1;
        }
        if (i >= can.length) return 0;

        if (dp[i][target] != -1 && dp[i][target] == 0) {
            return 0;
        }

        int p = 0;
        int size = map.get(can[i]);

        for(int j = 0; j <= size; j++) {
            if ( (target - j * can[i] ) >= 0) {
                List<Integer> newList = new ArrayList<>();
                for(int k = 0; k < list.size(); k++) {
                    newList.add(list.get(k));
                }
                for(int k = 0; k < j; k++) {
                    newList.add(can[i]);
                }
                p += solve(i + size, can, map, target - j*can[i], newList, dp);
            }
        }

        if (p > 0) {
            dp[i][target] = 1;
        } else {
            dp[i][target] = 0;
        }
        
        return dp[i][target];
    }
}