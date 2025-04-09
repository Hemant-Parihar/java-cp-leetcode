class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<Integer> temp = solve(i, nums, map);
            if (temp.size() > ans.size()) {
                ans = temp;
            }
        }
        return ans;
    }

    List<Integer> solve(int i, int[] nums, HashMap<Integer, List<Integer>> map) {
        if (i >= nums.length) return new ArrayList<>();
        if (i == nums.length - 1) return new ArrayList<>(List.of(nums[i]));

        if (map.containsKey(i)) {
            return map.get(i);
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[i]);
        List<Integer> global_temp_list = new ArrayList<>();

        for(int j = i + 1; j < nums.length; j++) {
            
            if (nums[j] % nums[i] == 0) {
                List<Integer> temp_list = solve(j, nums, map);
                if (temp_list.size() > global_temp_list.size()) {
                    global_temp_list = temp_list;
                }
            }
        }

        // System.out.println(i + " " + global_temp_list);

        ans.addAll(global_temp_list);
        map.put(i, ans);
        return ans;
    }
}