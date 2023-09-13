class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;
        int[] candy = new int[n];
        candy[0] = 1;
        for(int i = 1; i < n; i++) {
            if (ratings[i -1] < ratings[i]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
                int j = i - 1;
                while(j >= 0 && ratings[j] > ratings[j+ 1] && candy[j] < candy[j+1] + 1) {
                    candy[j] = candy[j+ 1] + 1;
                    j--;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += candy[i];
        }
        return ans;
    }
}