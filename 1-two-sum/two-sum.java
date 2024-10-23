class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            long val = target - nums[i];
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            } else {
                map.put( (long) nums[i], i);
            }
        }
        return null;
    }
}