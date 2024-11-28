class Solution {
    int INT_MAX = 10000000;
    public int minDifficulty(int[] arr, int d) {
        int n = arr.length;
        int[][] dp = new int[n][d + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int val = solve(0, arr, d, dp);
        if (val >= INT_MAX) return -1;
        return val;
    }

    int solve(int index, int[] arr, int d, int[][] dp) {
        int n = arr.length;
        if (index == arr.length ) {
            if (d == 0) return 0;
            return INT_MAX;
        }

        if ( ((n - index + 1) < d) || d <= 0) return INT_MAX;

        if (dp[index][d] != -1) return dp[index][d];

        int max = arr[index];
        int ans = INT_MAX;
        int temp_ans;
        for(int j = index; j <= (n - d); j++) {
            if (max < arr[j]) {
                max = arr[j];
            }
            temp_ans = max + solve(j + 1, arr, d - 1, dp);
            ans = Math.min(ans, temp_ans);
        }

        return dp[index][d] = ans;
    }
}