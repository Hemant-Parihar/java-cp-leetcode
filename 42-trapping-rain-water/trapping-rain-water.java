class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int prev = 0;

        int count = 0;
        for(int i = 1; i < n; i++) {
            if (height[prev] <= height[i]) {
                ans += (height[prev] * (i - prev - 1)) - count;
                prev = i;
                count = 0;
            } else {
                count += height[i];
            }
        }

        count = 0;
        prev = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            if (height[i] > height[prev]) {
                ans += (height[prev] * (prev - i - 1)) - count;
                prev = i;
                count = 0;
            } else {
                count += height[i];
            }
        }

        return ans;
    }
}