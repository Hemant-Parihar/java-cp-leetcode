class Solution {
    public int numberOfSubstrings(String s) {
        int a, b, c;
        a = b = c = 0;
        int n = s.length();

        int i = 0;
        int j = 0;

        int ans = 0;

        while(j < n) {

            if (s.charAt(j) == 'a') {
                a++;
            } else if (s.charAt(j) == 'b') {
                b++;
            } else {
                c++;
            }

            ans += i;

            while(a > 0 && b > 0 && c > 0) {
                ans++;
                if (s.charAt(i) == 'a') {
                    a--;
                } else if (s.charAt(i) == 'b') {
                    b--;
                } else {
                    c--;
                }

                i++;

            }

            j++;
        }

        return ans;
    }
}