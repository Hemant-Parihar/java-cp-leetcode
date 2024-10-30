class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int start = 0;
        int end = n - 1;
        int ans = 0;
        int temp_ans;
        while(start < end) {
            temp_ans = (end - start) * Math.min(height[start], height[end]);
            ans = Math.max(ans, temp_ans);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return ans;
    }
}