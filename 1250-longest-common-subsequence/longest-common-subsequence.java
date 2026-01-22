class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(n - 1, m - 1, text1, text2, dp);
    }

    int solve(int n, int m, String text1, String text2, int[][] dp) {
        if (n < 0 || m < 0) return 0;

        if (dp[n][m] != -1) return dp[n][m];

        int p = 0;
        if (text1.charAt(n) == text2.charAt(m)) {
            p = 1 + solve(n - 1, m - 1, text1, text2, dp);
        }
        int up = Math.max(solve(n - 1, m, text1, text2, dp), solve(n, m - 1, text1, text2, dp));
        return dp[n][m] = Math.max(p, up);
    }
}