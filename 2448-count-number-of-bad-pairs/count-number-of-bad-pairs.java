class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            nums[i] = nums[i] - i;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        long ans = ((long) n * (long)(n - 1)) / 2;

        for(int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                ans -= map.get(nums[i]);
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        return ans;
    }
}