class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] last = new int[26];
        for(int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int[] used = new int[26];


        int ans = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (used[ch - 'a'] == 1) continue;
            used[ch - 'a'] = 1;
            int j = last[ch - 'a'];
            if (i == j) continue;
            int[] temp = new int[26];

            for(int k = i + 1; k < j; k++) {
                if (temp[s.charAt(k) - 'a'] == 0) {
                    temp[s.charAt(k) - 'a'] = 1;
                    ans++;
                }
            }
        }

        return ans;
    }
}