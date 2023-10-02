class Solution {
    int mod = 1000000007;
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int[] nse = new int[n];
        Arrays.fill(nse, n);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        stack.clear();
        int[] pse = new int[n];
        Arrays.fill(pse, -1);
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                pse[stack.pop()] = i;
            }
            stack.push(i);
        }

        long ans = 0;
        for(int i = 0; i < n; i++) {
            int low = pse[i];
            int high = nse[i];
            long sum = prefix[high] - prefix[low + 1];
            ans = Math.max(ans, sum * nums[i]);
        }

        return (int)(ans % mod);
    }
}