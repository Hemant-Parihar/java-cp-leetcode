class Solution {

    long MAX_VALUE = 100000000000000000L;
    long[] pnums, pcost;
    int gc_count = 0;
    public long minimumCost(int[] nums, int[] cost, int k) {
        int n = nums.length;
        pnums = new long[n + 1];
        pcost = new long[n + 1];

        for(int i = 0; i < n; i++) {
            pnums[i + 1] = (long) nums[i] + pnums[i];
            pcost[i + 1] = (long) cost[i] + pcost[i];
        }

        long[][] dp = new long[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        long ans = solve2(0, 0, k, dp);
        return ans;
    }

    long solve2(int start, int end, int k, long[][] dp) {
        int n = pnums.length - 1;
        if (end == n) {
            if (start == n) return 0;
            return MAX_VALUE;
        }

        if (dp[start][end] != -1) return dp[start][end];

        long currentPrefixNums = pnums[end + 1] - pnums[start];
        long currentSuffixCosts = pcost[n] - pcost[start];

        long totalCurrentCosts = (currentPrefixNums + k) * currentSuffixCosts;

        long b = totalCurrentCosts + solve2(end + 1, end + 1, k, dp);
        long ub = solve2(start, end + 1, k, dp);

        return dp[start][end] = Math.min(b, ub);
    }

    long solve(int i, int count, int k, long[][] dp) {

        // if (count > 260) return MAX_VALUE;
        
        int j = pcost.length - 1 - 1;
        if (i == j) {
            return (pnums[j + 1] - pnums[0] + count * k) * (pcost[j + 1] - pcost[i]);
        }

        if (dp[i][count] != -1) {
            gc_count++;
            return dp[i][count];
        };

        long ans = (pnums[j + 1] - pnums[0] + count * k) * (pcost[j + 1] - pcost[i]);

        for(int z = i; z < j; z++) {
            long temp_ans = (pnums[z + 1] - pnums[0] + count * k) * (pcost[z + 1] - pcost[i]);
            temp_ans += solve(z + 1, count + 1, k, dp);
            ans = Math.min(ans, temp_ans);
        }

        return dp[i][count] = ans;
    }
}