class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                // we don't need this element any more.
                stack.pop();
            }

            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }

            stack.add(i);
        }

        // System.out.println(Arrays.toString(pse));

        stack.clear();

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = stack.peek();
            }

            stack.add(i);
        }

        // System.out.println(Arrays.toString(nse));

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (i - pse[i] - 1) + heights[i] * (nse[i] - i) );
        }

        return ans;
    }
}