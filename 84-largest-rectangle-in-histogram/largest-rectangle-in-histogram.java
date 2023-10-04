class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[n];
        Arrays.fill(nse, n);
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                nse[stack.pop()] = i;
            }
            stack.add(i);
        }
        
        stack.clear();
        int[] pse = new int[n];
        Arrays.fill(pse, -1);
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                pse[stack.pop()] = i;
            }
            stack.add(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            int val = (nse[i] - pse[i] - 1)*heights[i];
            ans = Math.max(ans, val);
        }

        return ans;
    }
}