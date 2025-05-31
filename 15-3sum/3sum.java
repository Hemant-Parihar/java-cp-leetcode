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

            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if (val == 0) {
                    ansSet.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                } else if (val < 0) {
                    j++;
                } else {
                    k--;
                }
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