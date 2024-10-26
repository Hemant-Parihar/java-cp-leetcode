class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] can, int target) {
        solve(0, can, target, new ArrayList<>());
        return ans;
    }

    void solve(int i, int[] can, int target, List<Integer> list) {
        if (target == 0) {
            ans.add(list);
            return;
        }
        if (i >= can.length) return;

        if (target - can[i] >= 0) {
            List<Integer> newList = new ArrayList<>();
            for(int k = 0; k < list.size(); k++) {
                newList.add(list.get(k));
            }
            newList.add(can[i]);
            solve(i, can, target - can[i], newList);
        }

        solve(i + 1, can, target, list);
    }
}