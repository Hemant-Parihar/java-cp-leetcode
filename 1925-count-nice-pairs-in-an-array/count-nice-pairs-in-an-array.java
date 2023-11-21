class Solution {
    int mod = 1000000007;
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int val = nums[i] - rev(nums[i]);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        long count = 0;
        for(int val : map.values()) {
            count += ((long)val * (val - 1)) / 2;
            count %= mod;
        }
        return (int)(count);
    }

    int rev(int num) {
        int val = 0;
        while(num > 0) {
            val = val * 10 + (num % 10);
            num /= 10;
        }
        return val;
    }
}