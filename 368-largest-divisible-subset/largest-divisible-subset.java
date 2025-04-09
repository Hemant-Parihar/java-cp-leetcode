class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        ArrayList[] map = new ArrayList[n];

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> temp = solve(i, nums, map);
            if (temp.size() > ans.size()) {
                ans = temp;
            }
        }
        List<Integer> final_ans = new ArrayList<>();
        final_ans.addAll(ans);
        return final_ans;
    }

    ArrayList<Integer> solve(int i, int[] nums, ArrayList[] map) {
        if (i >= nums.length) return new ArrayList<>();
        // if (i == nums.length - 1) return new ArrayList<>(List.of(nums[i]));

        if (map[i] != null) {
            return map[i];
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[i]);
        ArrayList<Integer> global_temp_list = new ArrayList<>();

        for(int j = i + 1; j < nums.length; j++) {
            
            if (nums[j] % nums[i] == 0) {
                ArrayList<Integer> temp_list = solve(j, nums, map);
                if (temp_list.size() > global_temp_list.size()) {
                    global_temp_list = temp_list;
                }
            }
        }

        ans.addAll(global_temp_list);
        map[i] = ans;
        return ans;
    }
}