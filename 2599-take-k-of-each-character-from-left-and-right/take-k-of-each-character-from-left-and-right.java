class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int a = 0;
        int b = 0;
        int c = 0;

        if (k == 0) return 0;
        
        int i = 0;
        while( i < n && (a < k || b < k || c < k) ) {
            if (s.charAt(i) == 'a') {
                a++;
            } else if (s.charAt(i) == 'b') {
                b++;
            } else {
                c++;
            }
            i++;
        }
        if (i == n && (a < k || b < k || c < k) ) {
           return -1;
        }
        
        i--;
        int ans = Integer.MAX_VALUE;

        for(int j = n - 1; j >= 0; j--) {

            while(i >= 0 && (a >= k && b >= k && c >= k)) {
                ans = Math.min(ans, i + 1 + (n - (j + 1)));
                if (s.charAt(i) == 'a') {
                    a--;
                } else if (s.charAt(i) == 'b') {
                    b--;
                } else {
                    c--;
                }
                i--;
            }

            if (a >= k && b >= k && c >= k) {
                ans = Math.min(ans, i + 1 + (n - (j + 1)) );
            }
            
            if (s.charAt(j) == 'a') {
                a++;
            } else if (s.charAt(j) == 'b') {
                b++;
            } else {
                c++;
            }

        }

        return ans;
    }
}