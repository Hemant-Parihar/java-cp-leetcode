class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, s, set, dp);
    }

    boolean solve(int index, String s, HashSet<String> set, int[] dp) {
        int n = s.length();
        if (index == n) return true;

        if (dp[index] != -1) {
            if (dp[index] == 1) return true;
            else return false;
        }

        boolean val = false;
        StringBuilder str = new StringBuilder();
        for(int i = index; i < n; i++) {
            str.append(s.charAt(i));
            if (set.contains(str.toString())) {
                val = solve(i + 1, s, set, dp);
                if (val == true) {
                    dp[index] = 1;
                    return true;
                }
            }
        }

        dp[index] = (val) ? 1 : 0;
        return val;
    }
}