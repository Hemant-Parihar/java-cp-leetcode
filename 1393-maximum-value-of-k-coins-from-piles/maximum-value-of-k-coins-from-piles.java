class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();

        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, k, piles, dp);
    }

    int solve(int i, int k, List<List<Integer>> piles, int[][] dp) {
        if (i == piles.size() || k == 0) return 0;

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int ans = 0;
        int sum = 0;
        int j = 0;
        int temp_ans;

        while(j <= k) {
            temp_ans = sum + solve(i + 1, k - j, piles, dp);
            ans = Math.max(ans, temp_ans);
            if (j == piles.get(i).size()) break;
            sum += piles.get(i).get(j);
            j++;
        }

        return dp[i][k] = ans;
    }
}