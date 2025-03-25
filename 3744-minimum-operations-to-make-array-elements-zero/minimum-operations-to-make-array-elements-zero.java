class Solution {
    public long minOperations(int[][] queries) {
        int n = queries.length;
        long ans = 0;
        int left, right, prev, curr;
        long l, r;
        for(int i = 0; i < n; i++) {
            left = queries[i][0];
            right = queries[i][1];
            prev = 1;
            long temp_ans = 0;
            for(int d = 1; d < 17 && prev <= right; d++) {
                curr = 4 * prev;
                l = Math.max(left, prev);
                r = Math.min(right, curr - 1);
                if (l <= r) {
                    temp_ans += (r - l + 1)*d;
                }
                prev = curr;
            }
            // System.out.println(temp_ans);
            // System.out.println( (temp_ans + 1) / 2);
            ans += (temp_ans + 1) / 2;
        }
        return ans;
    }
}