class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];

        int ans = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }

            // System.out.println(Arrays.toString(heights));


            ans = Math.max(ans, largestRectangleArea(heights));
        }

        return ans;
    }

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

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (i - pse[i] - 1) + heights[i] * (nse[i] - i) );
        }

        return ans;
    }
}