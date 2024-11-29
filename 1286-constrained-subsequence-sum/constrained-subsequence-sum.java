class Solution {

    class Node {
        int val, index;
        Node(int v, int i) {
            this.val = v;
            this.index = i;
        }
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> b.val - a.val );
        pq.add(new Node(dp[0], 0));

        for(int i = 1; i < n; i++) {
            int j = Math.max(0, i - k);

            while(!pq.isEmpty() && pq.peek().index < j) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                dp[i] = Math.max(dp[i], pq.peek().val + nums[i]);
            }

            while(!pq.isEmpty() && dp[i] > pq.peek().val) {
                pq.poll();
            }

            pq.add(new Node(dp[i], i));
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}