class Solution {
    class Node {
        int val;
        int freq;
        Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public int reductionOperations(int[] nums) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>((a, b) -> b.val - a.val);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = itr.next();
            queue.add( new Node((int)entry.getKey(), (int)entry.getValue() ) );
        }

        int ans = 0;
        int prev = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (queue.isEmpty()) {
                break;
            }
            ans += node.freq;
            ans += prev;
            prev += node.freq;
        }
        return ans;
    }
}