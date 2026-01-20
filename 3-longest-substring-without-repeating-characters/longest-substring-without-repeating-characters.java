class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int i = 0;
        int j = 1;
        int ans = 1;

        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        
        while(j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            } else {
                while(i < j && set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            ans = Math.max(ans, j - i);
            // System.out.println(set);
        }

        return ans;
    }
}