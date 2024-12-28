class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();

        long enc_for = 0;
        long enc_back = 0;

        long pow = 1;
        int r = -1;

        int mod = 1000000007;

        for(int i = 0; i < n; i++) {
            enc_for = enc_for * 29 + (s.charAt(i) - 'a' + 1);
            enc_for %= mod;
            enc_back = enc_back + (s.charAt(i) - 'a' + 1) * pow;
            enc_back %= mod;

            pow = (29 * pow) % mod ;

            if (enc_for == enc_back) {
                r = i;
            }
        }

        // System.out.println(r);

        int j = n - 1;
        StringBuilder str = new StringBuilder();

        for(; j > r; j--) {
            str.append(s.charAt(j));
        } 

        str.append(s);

        return str.toString();
    }
}