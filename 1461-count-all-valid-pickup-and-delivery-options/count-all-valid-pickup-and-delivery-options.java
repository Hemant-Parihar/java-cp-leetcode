class Solution {
    int mod = 1000000007;
    public int countOrders(int n) {
        long[][] dp = new long[n + 1][n + 1];
        for(int i = 0; i <=n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return (int)solve(n, 0, dp);
    }

    long solve(int pickUp, int delivery, long[][] dp) {
        if (dp[pickUp][delivery] != -1) {
            return dp[pickUp][delivery];
        }

        if (pickUp == 0) return dp[pickUp][delivery] = fac(delivery);

        long ans = 0;
        ans = (ans + (pickUp) * solve(pickUp - 1, delivery + 1, dp)) % mod;
        if (delivery > 0) {
            ans = (ans + (delivery) * solve(pickUp, delivery - 1, dp) ) % mod;
        }

        return dp[pickUp][delivery] = ans;
    }

    long fac(int delivery) {
        long ans = 1;
        for(int i = 2; i <= delivery; i++) {
            ans = (ans * i) % mod;
        }
        return ans;
    }
}