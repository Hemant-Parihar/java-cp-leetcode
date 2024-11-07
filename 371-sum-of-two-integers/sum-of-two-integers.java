class Solution {
    public int getSum(int a, int b) {
        int ans = 0;
        int c = 0;
        for(int i = 0; i < 32; i++) {
            if ((a & 1) == 0 && (b & 1) == 0 ) {
                ans = ans << 1;
                ans = ans | c;
                c = 0;
            } else if ( (a & 1) == 0 && ( b & 1 ) == 1 ) {
                if (c == 1) {
                    ans = ans << 1;
                    c = 1;
                } else {
                    ans = ans << 1;
                    ans = ans | 1;
                }
            } else if ( (a & 1) == 1 && ( b & 1 ) == 0) {
                if (c == 1) {
                    ans = ans << 1;
                    c = 1;
                } else {
                    ans = ans << 1;
                    ans = ans | 1;
                }
            } else if ( (a & 1) == 1 && ( b & 1 ) == 1) {
                if (c == 1) {
                    ans = ans << 1;
                    ans = ans | 1;
                } else {
                    ans = ans << 1;
                }
                c = 1;
            }
            a = a >> 1;
            b = b >> 1;
        }

        // System.out.println(ans);
        
        int ret = 0;
        for(int i = 0; i < 32; i++) {
            ret = ret * 2 + (ans & 1);
            ans = ans >> 1;
        }

        return ret;
    }
}