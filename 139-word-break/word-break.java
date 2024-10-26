class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0, s, wordDict, dp);
    }

    boolean solve(int i, String s, List<String> wordDict, int[] dp) {
        if (i >= s.length()) return true;
        if (dp[i] != -1) {
            if (dp[i] == 1) return true;
            else return false;
        }
        for(int j = 0; j < wordDict.size(); j++) {
            if (match(i, s, wordDict.get(j))) {
                int len = wordDict.get(j).length();
                boolean val = solve(i + len, s, wordDict, dp);
                if (val == true) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = 0;
        return false;
    }

    boolean match(int i, String s, String word) {
        int len = word.length();
        int j;
        for(j = 0; j < len && i + j < s.length(); j++) {
            if (s.charAt(i + j) != word.charAt(j)) {
                return false;
            }
        }
        if (j == len)
            return true;
        else
            return false;
    }
}