class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] nse = new int[n];
        Arrays.fill(nse, n);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                nse[stack.pop()] = i;
            }
            stack.add(i);
        }

        stack.clear();

        int[] pse = new int[n];
        Arrays.fill(pse, -1);
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                pse[stack.pop()] = i;
            }
            stack.add(i);
        }

        int score = 0;
        for(int u = 0; u < n; u++) {
            int j = nse[u] - 1;
            int i = pse[u] + 1;
            if (i <= k && k <= j) {
                score = Math.max(score, nums[u] * (j - i + 1));
            }
        }
        return score;
    }
}