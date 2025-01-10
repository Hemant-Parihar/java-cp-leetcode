class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];
        
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            if (isVowel(s)) {
                prefix[i + 1] = 1 + prefix[i];
            } else {
                prefix[i + 1] = prefix[i];
            }
        }

        int m = queries.length;
        int[] ans = new int[m];

        for(int i = 0; i < m; i++) {
            ans[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        
        return ans;
    }

    boolean isVowel(String str) {
        char s = str.charAt(0);
        char e = str.charAt(str.length() - 1);

        if ( (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') 
            && (e == 'a' || e == 'e' || e == 'i' || e == 'o' || e == 'u')
        ) {
            return true;
        }
        return false;
    }
}