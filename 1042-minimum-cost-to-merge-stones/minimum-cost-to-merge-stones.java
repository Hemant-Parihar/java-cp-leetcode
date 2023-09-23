class Solution {
    int INT_MAX = 100000;
    int fun_count = 0;
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if (n == 1) return 0;
        int sum = 0;
        for(int t = 0; t < n; t++) {
            sum += stones[t];
        }

        int[][][] dp = new int[n][n][k+1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int t = 0; t <= k; t++) {
                    dp[i][j][t] = -1;
                }
            }
        }


        int ans = sum + solve(0, n - 1, k, stones, k, dp);
        // System.out.println(fun_count);
        return ans >= INT_MAX ? -1 : ans;
    }

    int solve(int i, int j, int m, int[] stones, int k, int[][][] dp) {
        fun_count++;
        // System.out.println(i + " " + j + " " + m);

        if (dp[i][j][m] != -1) {
            return dp[i][j][m];
        }

        if (j - i + 1 == m) {
            // we already have all the piles.
            return 0;
        }

        if ((j - i + 1 < m)) {
            return INT_MAX;
        }

        int sum = 0;
        for(int t = i; t <= j; t++) {
            sum += stones[t];
        }

        if (j - i + 1 == k && m == 1) {
            return sum;
        }

        if (m == 1) {
            return sum + solve(i, j, k, stones, k, dp);
        }

        int ans = INT_MAX;
        for(int t = i; t < j; t++) {
            // subproblem from i to t, t + 1 to j.
            int temp_ans = INT_MAX;
            for(int u = 1; u < m; u++) {
                int ans1 = solve(i, t, u, stones, k, dp);
                if (ans1 >= INT_MAX) continue;
                // System.out.println(i + " " + t + " " + u + " " + ans1);
                int ans2 = solve(t + 1, j, m - u, stones, k, dp);
                // System.out.println(t + 1 + " " + j + " " + (m-u) + " " + ans2);
                temp_ans = Math.min(temp_ans, ans1 + ans2);
                if (t - i + 1 < u) {
                    break;
                }
            }
            ans = Math.min(ans, temp_ans);
        }

        dp[i][j][m] = ans;
        return ans;
    }
}