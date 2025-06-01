class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        solve(nums, ans, list, set);
        return ans;
    }

    void solve(int[] nums, List<List<Integer>> ans, List<Integer> list, HashSet<Integer> set) {
        int n = nums.length;
        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < n; i++) {
            if (!set.contains(nums[i])) {
                list.add(nums[i]);
                set.add(nums[i]);
                solve(nums, ans, list, set);
                list.remove(list.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}