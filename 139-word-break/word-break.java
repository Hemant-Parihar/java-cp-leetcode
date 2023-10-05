class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, s, set, dp);
    }

    boolean solve(int i, String s, HashSet<String> set, int[] dp) {

        int n = s.length();
        if (i == n) return true;

        if (dp[i] != -1) {
            if (dp[i] == 1) return true;
            return false;
        }

        StringBuilder str = new StringBuilder();
        for(int k = i; k < s.length(); k++) {
            
            if (k - i > 20) break;

            str.append(s.charAt(k));
            if (set.contains(str.toString())) {
                boolean val = solve(k + 1, s, set, dp);
                if (val == true) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = 0;
        return false;
    }
}