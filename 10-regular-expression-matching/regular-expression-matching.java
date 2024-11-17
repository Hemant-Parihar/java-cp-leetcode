class Solution {
    public boolean isMatch(String s, String p) {
        
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, s, p, dp);
    }

    boolean solve(int i, int j, String s, String p, int[][] dp) {
        if ( i == s.length() && j == p.length() ) return true;
        if ( (j == p.length() && i != s.length()) ) return false;

        if (i == s.length() && j != p.length() ) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*' ) {
                return solve(i, j + 2, s, p, dp);
            } else {
                return false;
            }
        }

        if (dp[i][j] != -1) {
            if (dp[i][j] == 1) return true;
            return false;
        }

        char p_ch = p.charAt(j);
        char p_ch_next = 'A';

        if (j + 1 < p.length())
            p_ch_next = p.charAt(j + 1);

        boolean val = false;
        if (p_ch == '.' || p_ch == s.charAt(i)) {
            if (p_ch_next != 'A' && p_ch_next == '*') {
                val = solve(i + 1, j + 2, s, p, dp);
                if (val == true) {
                    dp[i][j] = 1;
                    return true;
                }
                val = solve(i + 1, j, s, p, dp);
                if (val == true) {
                    dp[i][j] = 1;
                    return true;
                }
                val = solve(i, j + 2, s, p, dp);
            } else {
                val = solve(i + 1, j + 1, s, p, dp);
            }
        } else if (p_ch != s.charAt(i) ) {
            if (p_ch_next != 'A' && p_ch_next == '*') {
                // we can skip this matching at all.
                val = solve(i, j + 2, s, p, dp);
            } else {
                dp[i][j] = 0;
                return false;
            }
        }

        if (val == true) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = 0;
        }
        return val;
    }
}