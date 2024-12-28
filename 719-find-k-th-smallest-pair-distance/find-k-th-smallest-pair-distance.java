class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int l = 0;
        int r = nums[n - 1] - nums[0];

        while(l < r) {
            int mid = l + (r - l) / 2;
            if (countAllPair(nums, mid) < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    int countAllPair(int[] nums, int diff) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            int j = i + 1;
            while(j < n && (nums[j] - nums[i]) <= diff) {
                count++;
                j++;
            }
        }

        return count;
    }
}