class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length; 
        int[] l_max = new int[n];
        int[] r_max = new int[n];

        l_max[0] = nums[0];
        for(int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i - 1], nums[i]);
        }

        r_max[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], nums[i]);
        }

        // System.out.println(Arrays.toString(l_max));
        // System.out.println(Arrays.toString(r_max));

        long ans = 0;
        for(int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, (long) (l_max[i - 1] - nums[i]) * r_max[i + 1] );
        }

        return ans;
    }
}