class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        if (n == 0) return ans;
        ans[1] = 1;
        int count = 0;
        for(int i = 2; i <= n; i++) {
            if ( (i & (i - 1)) == 0) {
                ans[i] = 1;
                count = 0;
            } else {
                ans[i] = ans[count] + 1;
            }
            count++;
        }
        return ans;
    }
}