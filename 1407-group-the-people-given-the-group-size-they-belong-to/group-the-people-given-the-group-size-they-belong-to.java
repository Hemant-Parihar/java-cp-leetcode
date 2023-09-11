class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if (map.containsKey(groupSizes[i])) {
                map.get(groupSizes[i]).add(i);
            } else {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                map.put(groupSizes[i], queue);
            }
        }

        for(Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            Queue<Integer> queue = entry.getValue();
            // System.out.println(queue);
            List<Integer> list = new ArrayList<>();
            int count = 0;
            while(!queue.isEmpty()) {
                list.add(queue.poll());
                count++;
                if (count % key == 0) {
                    ans.add(new ArrayList<>(list));
                    list.clear();
                }
            }
        }
        return ans;
    }
}