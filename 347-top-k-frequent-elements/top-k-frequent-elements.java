class Solution {

    class Node{
        int val;
        int freq;
        Node(int v, int f) {
            this.val = v;
            this.freq = f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if ( map.containsKey(nums[i]) ) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> b.freq - a.freq );
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add( new Node(entry.getKey(), entry.getValue()) );
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            Node node = pq.poll();
            ans[i] = node.val;
        }
        return ans;
    }
}