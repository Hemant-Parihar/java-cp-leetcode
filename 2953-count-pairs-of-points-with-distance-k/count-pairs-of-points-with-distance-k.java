class Solution {
    public int countPairs(List<List<Integer>> c, int k) {
        int n = c.size();
        int ans = 0;

        int val = 0;
        while(val <= k) {
            HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                int x2 = c.get(i).get(0) ^ val;
                int y2 = c.get(i).get(1) ^ (k - val);

                Pair<Integer, Integer> pair = new Pair(x2, y2);
                if (map.containsKey(pair)) {
                    ans += map.get(pair);
                }
                Pair<Integer, Integer> newPair = new Pair(c.get(i).get(0), c.get(i).get(1));
                map.put(newPair, map.getOrDefault(newPair, 0) + 1);
            }
            val++;
        }
        return ans;
    }
}