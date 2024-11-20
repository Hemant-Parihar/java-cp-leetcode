class Solution {

    int INT_MAX = 100;

    List<String> ans = new ArrayList<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(words[i]);
        }

        int[] dp = new int[30];
        for(int i = 0; i < n; i++) {
            
            Arrays.fill(dp, -1);
            int val = solve(0, words[i], set, dp);
            if (val != 1) {
                ans.add(words[i]);
            }
        }

        return ans;
    }

    int solve(int i, String word, HashSet<String> set, int[] dp) {
        if (i == word.length()) return 0;

        if (dp[i] != -1) return dp[i];
        
        StringBuilder str = new StringBuilder();
        

        int ans = INT_MAX;
        int temp_ans;
        for(int k = i; k < word.length(); k++) {
            
            str.append(word.charAt(k));

            if (set.contains(str.toString())) {
                temp_ans = 1 +  solve(k + 1, word, set, dp);
                if (temp_ans < INT_MAX) return dp[i] = temp_ans;
            }
        }

        return dp[i] = INT_MAX;
    }
}