class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j < n) {
            char ch = s.charAt(j);
            if (map.containsKey(ch) && i <= map.get(ch)) {
                i = map.get(ch);
                i++;   
            }
            map.put(ch, j);
            j++;
            ans = Math.max(ans, j - i);
            // System.out.println(j - i);
        }
        return ans;
    }
}