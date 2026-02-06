class Solution {

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);
        return solve(0, s, dp) - 1;
    }

    int solve(int i, String s, int[] dp) {
        int n = s.length();
        if (i == n) return 0;

        if (dp[i] != -1) return dp[i];

        int ans = n - i;
        for(int j = i; j < n; j++) {
            if (isPal(i, j, s)) {
                int temp = 1 + solve(j + 1, s, dp);
                ans = Math.min(ans, temp);
            }
        }

        return dp[i] = ans;
    }

    boolean isPal(int i, int j, String s) {
        while( i < j && s.charAt(i) == s.charAt(j) ) {
            i++;
            j--;
        }
        if (i >= j) return true;
        return false;
    }
}