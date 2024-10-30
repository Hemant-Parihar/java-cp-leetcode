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

        solve(0, can, map, target, new ArrayList<>());
        return ans;
    }

    void solve(int i, int[] can, HashMap<Integer, Integer> map, int target, List<Integer> list) {
        
        if (target == 0) {
            ans.add(list);
            return;
        }
        if (i >= can.length) return;
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
                solve(i + size, can, map, target - j*can[i], newList);
            }
        }
    }
}