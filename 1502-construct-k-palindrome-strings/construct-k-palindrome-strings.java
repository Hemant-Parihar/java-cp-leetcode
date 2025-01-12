class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq = new int[26];

        if (s.length() < k) return false;

        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int count = 0;
        for(int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) count++;
        }

        if (count > k) return false;
        return true;
    }
}