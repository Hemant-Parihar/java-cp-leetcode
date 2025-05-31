class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int prev_i = Integer.MIN_VALUE;
        int prev_j = Integer.MIN_VALUE;

        for(int i = 0; i < n - 2; i++) {

            if (nums[i] == prev_i) continue;

            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if (val == 0) {
                    ans.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    while(nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                } else if (val < 0) {
                    j++;
                } else {
                    k--;
                }
            }

            prev_i = nums[i];
        }

        return ans;
    }
}