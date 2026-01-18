class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int i, j;
        List<List<Integer>> ans = new ArrayList<>();
        int prev_i = Integer.MIN_VALUE;
        for(i = 0; i < n-2; i++) {

            if (prev_i == nums[i]) {
                continue;
            }

            if (nums[i] > 0) break;

            int prev_j = Integer.MIN_VALUE;
            for(j = i + 1; j < n -1; j++) {

                if (prev_j == nums[j]) {
                    continue;
                }

                if (nums[i] + nums[j] > 0 ) {
                    break;
                }

                int val = -(nums[i] + nums[j]);
                

                if (map.containsKey(val)) {

                    int index = map.get(val);
                    if (index > j) {
                        ans.add(List.of(nums[i], nums[j], val));
                    }
                }

                prev_j = nums[j];
            }

            prev_i = nums[i];
        }

        return ans;
    }
}