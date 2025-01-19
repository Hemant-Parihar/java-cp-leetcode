class Solution {
    public char findKthBit(int n, int k) {
        return solve(n, k, false);
    }

    char solve(int n, int k, boolean inv) {
        if (inv == false) {
            if (k == 1 || n == 1) return '0';
            if (k == 2 || k == 3 ) return '1';
        } else {
            if (k == 1 || n == 1) return '1';
            if (k == 2 || k == 3 ) return '0';
        }
        

        int len = (int) Math.pow(2, n) - 1;
        int cal_k = k;

        if (k == (len / 2) + 1) {
            if (inv == false) return '1';
            return '0';
        } else if (k > ((len / 2) + 1)) {
            inv = !inv;
            cal_k = len - k + 1;
        }

        return solve(n - 1, cal_k, inv);
    }
}