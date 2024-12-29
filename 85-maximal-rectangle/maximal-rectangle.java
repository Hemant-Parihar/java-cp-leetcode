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

            ans = Math.max(ans, largestRectangleArea(heights));
        }

        return ans;
    }

    class Node {
        int val;
        int index;
        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Node> stack = new Stack<>();
        int area = 0;
        for(int i = 0; i < n; i++) {
            int index = i;
            while(!stack.isEmpty() && stack.peek().val >= heights[i]) {
                Node node = stack.pop();
                int d = i - node.index;
                area = Math.max(area, d * node.val);
                index = node.index;
            }
            stack.push(new Node(heights[i], index));
        }

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            int d = n - node.index;
            area = Math.max(area, d * node.val);
        }

        return area;
    }
}