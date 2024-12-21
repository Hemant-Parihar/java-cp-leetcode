class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] prefix = new int[n + 1];
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + nums[i - 1];
            int val = prefix[i] - k;
            if (map.containsKey(val)) {
                ans += map.get(val);
            }
            if (map.containsKey(prefix[i])) {
                map.put(prefix[i], map.get(prefix[i]) + 1);
            } else {
                map.put(prefix[i], 1);
            }
        }
        return ans;
    }
}