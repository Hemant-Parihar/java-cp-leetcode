class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        int s = 0;
        int e = nums.length - 1;
        while(s < e) {
            int mid = s + ( (e -s) / 2);
            System.out.println(s + " " + mid + " " + e);
            if (nums[mid] > nums[s]) {
                if (mid + 1 <= e && nums[mid + 1] < nums[mid]) {
                    return nums[mid + 1];
                } 
                s = mid + 1;
            } else {
                ans = Math.min(ans, nums[e]);
                e = mid - 1;
            }
            ans = Math.min(ans, nums[mid]);
        }
        return ans;
    }
}