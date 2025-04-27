class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, 0, new StringBuilder(), ans);
        return ans;
    }

    void solve(int n, int count, StringBuilder str, List<String> ans) {
        if (n == 0 && count == 0) {
            ans.add(str.toString());
            return;
        }

        if (n > 0) {
            solve(n - 1, count + 1, str.append('('), ans);
            str.deleteCharAt(str.length() - 1);
        }

        if (count > 0) {
            solve(n, count - 1, str.append(')'), ans);
            str.deleteCharAt(str.length() - 1);
        }

    }
}