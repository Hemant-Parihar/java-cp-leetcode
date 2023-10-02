class Solution {
    public List<String> generateParenthesis(int n) {
        HashSet<String> set = new HashSet<>();
        solve(0, 0, n, "", set);
        List<String> ans = new ArrayList<>();
        ans.addAll(set);
        return ans;
    }

    void solve(int open, int closed, int n, String str, HashSet<String> ans) {
        if (closed > open || open > n) return;
        if (open + closed == 2*n) {
            ans.add(str);
            return;
        }
        if (open == n) {
            solve(open, closed + 1, n, str + ")", ans);
        }
        solve(open + 1, closed, n, str + "(", ans);
        solve(open, closed + 1, n, str + ")", ans);
    }
}