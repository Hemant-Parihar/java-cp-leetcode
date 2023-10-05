class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j > i; j--) {
                if (height[j] >= height[i]) {
                    ans = Math.max(ans, height[i] * (j - i));
                    break;
                } else {
                    ans = Math.max(ans, height[j] * (j - i));
                }
            }
        }
        return ans;
    }
}