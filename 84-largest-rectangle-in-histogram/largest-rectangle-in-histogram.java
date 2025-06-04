class Solution {

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
        int index = 0;
        for(int i = 0; i < n; i++) {
            index = i;
            while(!stack.isEmpty() && stack.peek().val >= heights[i]) {
                Node node = stack.pop();
                area = Math.max(area, node.val * (i - node.index));
                index = node.index;
            }

            area = Math.max(area, heights[i] * (i - index));
            stack.add(new Node(heights[i], index));
        }

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            area = Math.max(area, node.val * (n - node.index));
        }

        return area;
    }
}