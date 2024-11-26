class Solution {
    public int maximumScore(int[] nums, int k) {
        int i = k;
        int j = k;
        int ans = nums[i];
        int min = nums[i];
        int n = nums.length;
        
        while( i >=0 || j < nums.length ) {
            while (i > 0 && nums[i - 1] >= min) {
                i--;
            }

            while ( (j + 1) < nums.length && nums[j + 1] >= min) {
                j++;
            }

            ans = Math.max(ans, min * (j - i + 1));
            // System.out.println(min + " " + j + " " + i);

            if (i == 0 && j == (n - 1)) {
                // we have reached the end.
                break;
            } else if (i == 0) {
                min = nums[j + 1];
                j++;
            } else if (j == (n - 1)) {
                min = nums[i - 1];
                i--;
            } else {
                if (nums[i - 1] >= nums[j+1]) {
                    min = nums[i - 1];
                    i--;
                } else {
                    min = nums[j + 1];
                    j++;
                }
            }

        }

        return ans;
    }
}