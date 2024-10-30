class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(1, k, n, new ArrayList<>());
        return ans;
    }

    void solve(int i, int k, int n, List<Integer> list) {
        if (k == 0 && n == 0) {
            ans.add(list);
            return;
        }
        if (k < 0 || n < 0 || i > 9) return;

        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        newList.add(i);
        solve(i + 1, k - 1, n - i, newList);
        solve(i + 1, k, n, list);
    }
}