class Solution {

    int MOD = 1000000007;

    int[] f;
    public int countOrders(int n) {
        long c = 1;
        f = new int[n + 1];
        f[0] = 1;
        for(int i = 1; i <= n; i++) {
            c = c * i;
            c = c % MOD;
            f[i] = (int) c;
        }

        long[][] dp = new long[n+1][n+1];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return (int) solve(0, 0, n, dp);
    }

    long solve(int p, int d, int n, long[][] dp) {
        if (d > p) return 0;
        if (p == n) {
            // we have processed all the element.
            int count = n - d;
            return f[count];
        }

        if (dp[p][d] != -1) return dp[p][d];

        long val =  (n - p) * solve(p + 1, d, n, dp);
        val %= MOD;
        long val2 = (p - d) * solve(p, d + 1, n, dp);
        val2 %= MOD;

        return dp[p][d] = ((val + val2) % MOD);
    }
}