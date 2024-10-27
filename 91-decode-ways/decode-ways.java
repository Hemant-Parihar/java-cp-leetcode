class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }

    int solve(int i, String s, int[] dp) {
        int n = s.length();
        if (i == n) return 1;
        if (s.charAt(i) == '0') return 0;

        if (dp[i] != -1) return dp[i];

        int p = solve(i + 1, s, dp);
        int pp = 0;
        if (i + 1 < n) {
            if (s.charAt(i) == '1')
                pp = solve(i + 2, s, dp);
            else if (s.charAt(i) == '2' && s.charAt(i + 1) < '7') {
                pp = solve(i + 2, s, dp);
            }
        }
        dp[i] = p + pp;
        return dp[i];
    }
}