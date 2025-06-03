class Solution {

    class Node {
        int val;
        int index;
        Node(int v, int i) {
            this.val = v;
            this.index = i;
        }
        @Override
        public String toString() {
            return val + " " + index + " !. ";
        }
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        List<Node> list = new ArrayList<>();

        int area = 0;
        for(int i = 0; i < n; i++) {
            area = Math.max(area, heights[i]);

            int index = i;


            while(list.size() > 0 && list.get(list.size() - 1).val >= heights[i]) {
                Node node = list.remove(list.size() - 1);
                index = node.index;
                area = Math.max(area, heights[i] * (i - index + 1));
            }

            for(int j = 0; j < list.size(); j++) {
                Node node = list.get(j);
                area = Math.max(area, node.val * (i - node.index + 1));
            }

            Node newNode = new Node(heights[i], index);
            list.add(newNode);
        }

        // System.out.println(stack);

        // while(stack.size() > 1) {
        //     Node node = stack.pop();
        //     area = Math.max(area, stack.peek().val * (node.index - stack.peek().index + 1));
        //     stack.peek().index = node.index;
        // }

        return area;
    }
}