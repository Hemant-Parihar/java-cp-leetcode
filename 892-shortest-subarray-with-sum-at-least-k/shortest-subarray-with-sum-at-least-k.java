class Solution {

    class Node {
        long prefix;
        int end_index;
        Node(long p, int e) {
            this.prefix = p;
            this.end_index = e;
        }
    }

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Node> pq = new PriorityQueue<Node>( (a, b) -> Long.compare(a.prefix, b.prefix));

        int res = n + 1;
        long curr_sum = 0;
        for(int i = 0; i < n; i++) {
            curr_sum += nums[i];

            // it might be possible that this curr_sum is the ans.
            if (curr_sum >= k) {
                res = Math.min(res, i + 1);
            }

            while(!pq.isEmpty() && curr_sum - pq.peek().prefix >= k) {
                // we can remove this prefix sum from the heep.
                Node node = pq.poll();
                res = Math.min(res, i - node.end_index);
            }

            pq.add(new Node(curr_sum, i));
        }

        if (res == n + 1) return -1;
        return res;
    }
}