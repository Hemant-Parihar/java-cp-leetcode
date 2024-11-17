class Solution {

    int[][] dp = new int[102][102];

    public int minCost(int n, int[] cuts) {
        var c = new ArrayList<Integer>();
        for (int cut : cuts)
            c.add(cut);
        c.addAll(Arrays.asList(0, n));
        Collections.sort(c);

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(c, 0, c.size() - 1, dp);
    }

    int solve(ArrayList<Integer> cuts, int i, int j, int[][] dp) {
        if (j - i < 0)
            return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for(int k = i + 1; k <= j - 1; k++) {
            int temp_ans = ( (cuts.get(j) - cuts.get(i)) + solve(cuts, i, k, dp)
                             + solve(cuts, k, j, dp) );
            ans = Math.min(ans, temp_ans);
        }

        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }

        dp[i][j] = ans;
        return ans;
    }
}