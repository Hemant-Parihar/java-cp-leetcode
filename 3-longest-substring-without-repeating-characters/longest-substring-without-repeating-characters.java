class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j < n) {
            char ch = s.charAt(j);
            if (set.contains(ch)) {
                while(i < j && s.charAt(i) != ch) {
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            } else {
                set.add(ch);
                j++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}