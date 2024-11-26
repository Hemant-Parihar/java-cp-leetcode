class Solution {
    class Node{
        int val;
        int index;
        Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>( (a, b) -> b.val - a.val );

        for(int i = 0, j = 0; j < nums.length; j++) {
            while(!maxHeap.isEmpty() && maxHeap.peek().val < nums[j]) {
                maxHeap.poll();
            }
            maxHeap.add(new Node(nums[j], j));

            if (j - i + 1 == k) {
                while(maxHeap.peek().index < i) {
                    maxHeap.poll();
                }
                ans[i] = maxHeap.peek().val;
                i++;
            }
        }
        return ans;
    }
}