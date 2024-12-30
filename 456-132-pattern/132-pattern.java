class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min_i = new int[n];

        int index = 0;
        min_i[0] = 0;
        for(int i = 1; i < n; i++) {
            if (nums[index] > nums[i]) {
                index = i;
            }
            min_i[i] = index;
        }

        int[] pge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = stack.peek();
            }
            stack.add(i);
        }

        // System.out.println(Arrays.toString(min_i));
        // System.out.println(Arrays.toString(pge));

        for(int i = n - 1; i > 1; i--) {
            int g_i = pge[i];
            if (g_i == -1) continue;
            if ( nums[min_i[g_i]] < nums[i]) return true;
        }
        return false;
    }
}