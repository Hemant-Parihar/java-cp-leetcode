class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        int[] prefixMin = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            prefixMin[i] = min;
        }

        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        for(int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                nge[stack.pop()] = i;
            }
            stack.add(i);
        }

        // System.out.println(Arrays.toString(nge));

        for(int i = n - 1; i >= 0; i--) {
            int index = nge[i];
            if (index != -1 && nums[i] > prefixMin[index]) return true;
        }
        return false;
    }
}