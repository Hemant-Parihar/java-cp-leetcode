class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            stack.add(nums[i]);
        }

        int[] nge = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            nge[i] = (!stack.isEmpty()) ? stack.peek() : -1;

            stack.add(nums[i]);
        }

        return nge;
    }
}