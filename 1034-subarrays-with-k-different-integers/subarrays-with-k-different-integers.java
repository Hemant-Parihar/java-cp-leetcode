class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArrayWithAtmostKDistinct(nums, k) - subArrayWithAtmostKDistinct(nums, k - 1);
    }

    int subArrayWithAtmostKDistinct(int[] nums, int k) {
        if (k == 0) return 1;

        int i = 0;
        int j = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        while(j < n) {

            if (map.containsKey(nums[j])) {
                map.put( nums[j], map.get(nums[j]) + 1);
                j++;
            } else if (map.size() < k) {
                map.put(nums[j], 1);
                j++;
            } else if (map.size() == k) {
                // this means, if we add one more element to the map, it will become (K+1) distinct element.
                // now we need to calculate all the subarray that are starting at i, and having Atmost K distinct element.
                res += (j - i);
                if (map.get(nums[i]) == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
                i++;
            }

        }

        if (i < n) {
            int num = j - i;
            res += (num * (num + 1)) / 2;
        }
        return res + 1;
    }
}