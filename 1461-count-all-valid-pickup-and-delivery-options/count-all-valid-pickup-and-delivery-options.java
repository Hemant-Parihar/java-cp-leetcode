class Solution {
    int mod = 1000000007;
    public int countOrders(int n) {
        if (n == 1) return 1;

        long ans = (2*n - 1) * n;

        long val = countOrders(n - 1);

        ans *= val;
        ans %= mod;

        return  (int)ans;
    }
}