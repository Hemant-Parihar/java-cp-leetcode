class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int last_dup_index = -1;
        Stack<Integer> stack = new Stack<>();

        for(int i =  n - 1; i >= 0; i--) {
            if (stack.contains(nums[i])) {
                last_dup_index = i;
                break;
            } else {
                stack.add(nums[i]);
            }
        }

        int ans = 0;
        for(int i = 0; i <= last_dup_index; i = i + 3) {
            ans++;
        }
        return ans;
    }
}