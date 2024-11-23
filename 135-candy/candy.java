class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] front = new int[n];

        front[0] = 1;
        for(int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                front[i] = 1 + front[i - 1];
            } else {
                front[i] = 1;
            }
        }

        int[] back = new int[n];
        back[n - 1] = 1;
        for(int j = n - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                back[j] = 1 + back[j + 1];
            } else {
                back[j] = 1;
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            ans += Math.max(front[i], back[i]);
        }

        return ans;
    }
}