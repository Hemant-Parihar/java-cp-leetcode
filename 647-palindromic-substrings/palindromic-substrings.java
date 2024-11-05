class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = n;

        for(int i = 1; i < n; i++) {
            int j = i - 1;
            int k = i + 1;
            while(j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                ans++;
            }
        }

        for(int i = 1; i < n; i++) {
            int j = i - 1;
            int k = i;
            while(j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                ans++;
            }
        }

        return ans;
    }
}