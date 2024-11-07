class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean f = false;
        int abc = -1;
        for(int i = 0; i < n; i++) {
            int val = nums[i];
            if (val == 0) abc = i;
            if (val == n || val == -n) {
                f = true;
            } else {
                if (val < 0)
                    val = -val;
                if (nums[val] > 0)
                    nums[val] = -nums[val];
            }

        }
        if (f == false) return n;

        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < n; i++) {
            if (nums[i] > 0 && i != abc) return i;
        }

        return abc;
    }
}