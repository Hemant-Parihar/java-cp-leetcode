class Solution {
    public List<List<Integer>> combinationSum(int[] can, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        solve(0, can, target, ans, new ArrayList<>());
        List<List<Integer>> ret = new ArrayList<>();
        for(List<Integer> list : ans) {
            ret.add(list);
        }
        return ret;
    }

    void solve(int i, int[] can, int target, HashSet<List<Integer>> ans, List<Integer> list) {
        int n = can.length;
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (i == n) return;

        if (target >= can[i]) {
            list.add(can[i]);
            solve(i, can, target - can[i], ans, list);
            list.remove(list.size() - 1);
        }

        solve(i + 1, can, target, ans, list);

    }
}