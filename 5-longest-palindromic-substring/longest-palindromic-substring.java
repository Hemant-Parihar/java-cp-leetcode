class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        String ans = "";
        int len = 0;
        for(int k = 0; k < n; k++) {
            int i = k - 1;
            int j = k + 1;
            
            while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }

            if (j - i - 1 > len) {
                ans = s.substring(i + 1, j);
                len = ans.length();
            }
        }

        for(int k = 0; k < n; k++) {
            int i = k;
            int j = k + 1;
            
            while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }

            if (j - i - 1 > len) {
                ans = s.substring(i + 1, j);
                len = ans.length();
            }
        }

        return ans;
    }
}