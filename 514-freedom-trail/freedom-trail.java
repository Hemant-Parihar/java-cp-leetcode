class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, ring, key, dp);
    }

    int solve(int i, int j, String ring, String key, int[][] dp) {
        if (j == key.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];


        if (ring.charAt(i) == key.charAt(j)) {
            dp[i][j] = 1 + solve(i, j + 1, ring, key, dp);
            return dp[i][j];
        }

        int ans1 = 0;
        int k = i;
        while(ring.charAt(k) != key.charAt(j)) {
            k++;
            if (k == ring.length()) {
                k = 0;
            }
            ans1++;
        }

        ans1 += 1 + solve(k, j + 1, ring, key, dp);

        int ans2 = 0;
        k = i;
        while(ring.charAt(k) != key.charAt(j)) {
            k--;
            if (k == -1) {
                k = ring.length() - 1;
            }
            ans2++;
        }

        ans2 += 1 + solve(k, j + 1, ring, key, dp);

        return dp[i][j] = Math.min(ans1, ans2);      
    }
}