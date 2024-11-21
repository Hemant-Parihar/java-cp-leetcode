class Solution {

    int MOD = 1000000007;
    public int numWays(String[] words, String target) {
        if (target.length() > words[0].length()) return 0;

        int n = words[0].length();
        int m = target.length();
        long[][] dp = new long[n][m];

        for(int i = 0; i < words[0].length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        int[][] count = new int[26][n];

        for(int k = 0; k < 26; k++) {
            char ch = (char) ('a' + k);

            for(int i = 0; i < words[0].length(); i++) {
                int num = 0;
                for(int j = 0; j < words.length; j++) {
                    if (ch == words[j].charAt(i)) {
                        num++;
                    }
                }
                count[k][i] = num;
            }

        }

        return (int) solve(0, 0, words, target, dp, count);
    }

    long solve(int i, int j, String[] words, String target, long[][] dp, int[][] count) {
        if (j == target.length()) return 1;
        if (i == words[0].length() && j < target.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        long p = 0, up = 0;
        char ch = target.charAt(j);

        long num = count[ch - 'a'][i];
        long val = solve(i + 1, j + 1, words, target, dp, count) % MOD;

        p = (num * val) % MOD;
        
        
        up = solve(i + 1, j, words, target, dp, count);

        return dp[i][j] = (p + up) % MOD;
    }
}