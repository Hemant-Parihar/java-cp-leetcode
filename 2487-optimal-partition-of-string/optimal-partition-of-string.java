class Solution {
    public int partitionString(String s) {
        int ans = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                ans++;
                set.clear();
            }
            set.add(s.charAt(i));
        }

        if (set.size() > 0) {
            ans++;
        }
        return ans;
    }
}