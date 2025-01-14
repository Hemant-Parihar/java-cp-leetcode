class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            arr[i][0] = nums[i] - k;
            arr[i][1] = nums[i] + k;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int ans = 1;

        for(int i = 1; i < n; i++) {
            
            int start = 0;
            int end = i;
            
            while(start < end) {
                int mid = start + (end - start) / 2;

                if (arr[mid][1] < arr[i][0]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            
            ans = Math.max(i - start + 1, ans);
        }

        return ans;
    }
}