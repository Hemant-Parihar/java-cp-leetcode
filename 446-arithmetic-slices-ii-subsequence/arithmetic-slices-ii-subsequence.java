class Solution {

    HashMap<Pair<Integer, Long>, Integer> map = new HashMap<>();
    int ans = 0;

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                ans += solve(j,  ( (long) nums[j] - (long) nums[i]), nums);
            }
        }

        return ans;
    }

    int solve(int index, long diff, int[] nums) {
        int n = nums.length;
        Pair<Integer, Long> pair = new Pair<>(index, diff);

        if (map.containsKey(pair)) return map.get(pair);

        int ans = 0;
        for(int i = index + 1; i < n; i++) {
            if ( ( (long) nums[i] - (long) nums[index]) == diff) {
                ans += 1 + solve(i, diff, nums);
            }
        }

        map.put(pair, ans);
        return ans;
    }
}