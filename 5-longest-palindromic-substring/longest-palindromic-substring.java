class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int ans = 1;
        int start = 0;
        int end = 0;
        for(int i = 1; i < n; i++) {
            int j = i - 1;
            int k = i + 1;
            while(j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            if (k - j - 1 > ans) {
                ans = Math.max(ans, k - j - 1);
                start = j + 1;
                end = k - 1;
            }
            
        }

        for(int i = 1; i < n; i++) {
            int j = i - 1;
            int k = i;
            while(j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            if (k - j - 1 > ans) {
                ans = Math.max(ans, k - j - 1);
                start = j + 1;
                end = k - 1;
            }
        }

        StringBuilder str = new StringBuilder();
        for(int i = start; i <= end; i++) {
            str.append(s.charAt(i));
        }

        return str.toString();
    }
}