class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        list.add(nums[0]);

        for(int i = 1; i < n; i++) {
            if (list.get(list.size() - 1) < nums[i]) {
                list.add(nums[i]);
            } else {
                int index = findLowerBound(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        
        return list.size();
    }

    public int findLowerBound(List<Integer> list, int target) {
        int index = Collections.binarySearch(list, target);

        if (index >= 0) {
            // If target is found, move to the first occurrence
            while (index > 0 && list.get(index - 1).equals(target)) {
                index--;
            }
            return index;
        } else {
            // If target is not found, calculate insertion point
            return -(index + 1);
        }
    }
}