class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        dp[0] = 1;

        for(int i = 1; i < n; i++) {
            if (list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                dp[i] = list.size();
            } else {
                int index = findLowerBound(list, nums[i]);
                if (list.get(index) == nums[i]) {
                    list.set(index + 1, nums[i]);    
                    dp[i] = index + 1 + 1;
                } else {        
                    list.set(index, nums[i]);
                    dp[i] = index + 1;
                }
            }
            // System.out.println(list);
        }

        return dp;
    }

    public int findLowerBound(List<Integer> list, int target) {
        int index = Collections.binarySearch(list, target);
        int n = list.size();

        if (index >= 0) {
            // If target is found, move to the last occurrence
            while (index < n && list.get(index).equals(target)) {
                index++;
            }
            return index;
        } else {
            // If target is not found, calculate insertion point
            return -(index + 1);
        }
    }
}