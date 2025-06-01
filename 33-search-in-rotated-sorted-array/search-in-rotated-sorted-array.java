class Solution {
    public int search(int[] nums, int target) {
        int peak = findPeak(nums);
        // System.out.println(peak);
        int left = binarySearch(0, peak, nums, target);
        if (left != -1) return left;
        return binarySearch(peak + 1, nums.length - 1, nums, target);
    }

    int findPeak(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start < end) {
            int mid = (start + end) / 2;
            if ( (mid + 1) <= end && nums[mid + 1] < nums[mid]) return mid;
            else if (nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }



        return -1;
    }

    int binarySearch(int start, int end, int[] nums, int target) {

        while(start < end) {
            int mid = (start + end) / 2;
            // System.out.println(start + " " + end + " " + mid);
            if (nums[mid] == target) return mid;
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] == target) return start;
        return -1;

    }
}