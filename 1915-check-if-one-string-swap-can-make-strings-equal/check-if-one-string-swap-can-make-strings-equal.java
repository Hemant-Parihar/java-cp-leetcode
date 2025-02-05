class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        
        for(int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s2.length(); i++) {
            f2[s2.charAt(i) - 'a']++;
        }

        // System.out.println(Arrays.toString(f1));
        // System.out.println(Arrays.toString(f2));

        for(int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }

        int diff = 0;
        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        if (diff <= 2) return true;
        // System.out.println(diff);
        return false;
    }
}