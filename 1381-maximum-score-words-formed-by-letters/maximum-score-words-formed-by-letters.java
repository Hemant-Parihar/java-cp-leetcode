class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for(int i = 0; i < letters.length; i++) {
            count[letters[i] - 'a']++;
        }
        return solve(0, words, count, score);
    }

    int solve(int i, String[] words, int[] count, int[] score) {
        if (i == words.length) return 0;

        int p = 0;
        if (validate(words[i], count)) {
            int val = 0;
            for(int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                val += score[ch - 'a'];
                count[ch - 'a']--;
            }
            p = val + solve(i + 1, words, count, score);
            for(int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                count[ch - 'a']++;
            }
        }
        int up = solve(i + 1, words, count, score);
        
        return Math.max(p, up);
    }

    boolean validate(String str, int[] count) {
        int[] copy = count.clone();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (copy[ch - 'a'] == 0) return false;
            copy[ch - 'a']--;
        }
        return true;
    }
}