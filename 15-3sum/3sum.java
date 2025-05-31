class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        HashSet<List<Integer>> ansSet = new HashSet<>();

        int prev_i = Integer.MIN_VALUE;
        int prev_j = Integer.MIN_VALUE;

        for(int i = 0; i < n - 2; i++) {

            if (nums[i] == prev_i) continue;

            HashSet<Integer> set = new HashSet<>();

            for(int j = i + 1; j < n; j++) {
                
                int val = -(nums[i] + nums[j]);
                if (set.contains(val)) {
                    ansSet.add(new ArrayList<>(List.of(nums[i], val, nums[j])));
                }

                set.add(nums[j]);
            }

            prev_i = nums[i];
        }

        // System.out.println(ansSet);

        for(List<Integer> list : ansSet) {
            ans.add(list);
        }

        return ans;
    }
}