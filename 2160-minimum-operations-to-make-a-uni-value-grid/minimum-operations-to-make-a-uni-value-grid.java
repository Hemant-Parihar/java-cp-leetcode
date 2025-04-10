class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] nums = new int[m * n];

        if (m * n == 1) return 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                nums[n*i + j] = grid[i][j];
            }
        }

        n = nums.length;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));

        int val = nums[0] % x;
        for(int i = 1; i < n; i++) {
            if ( nums[i] % x != val ) {
                // System.out.println(nums[i] + " " + val + " " + (nums[i] % x));
                return -1;  
            };
        }

        int mid;
        
        // if (n % 2 == 0) {
        //     mid = nums[n / 2 - 1] + nums[n / 2];
        //     mid /= 2;

        // } else {
        //     mid = nums[n / 2];
        // }
        mid = nums[n / 2];

        // System.out.println(mid);

        int ans = 0;
        for(int i = 0; i < n; i++) {
            int diff = Math.abs(nums[i] - mid);
            ans += diff / x;
        }
        return ans;
    }
}