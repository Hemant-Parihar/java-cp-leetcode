class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        // System.out.println(Arrays.toString(nums));

        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (prev == nums[i]) continue;
            int s = i + 1;
            int e = nums.length - 1;
            int target = 0 - nums[i];

            while(s < e) {
                if (nums[s] + nums[e] > target) {
                    int temp = nums[e];
                    e = e - 1;
                    while (e - 1 > s && nums[e] == temp) {
                        e = e - 1;
                    }
                } else if (nums[s] + nums[e] < target) {
                    int temp = nums[s];
                    s = s + 1;
                    while(s + 1 < e && nums[s] == temp) {
                        s = s + 1;
                    }
                } else if (s < e) {
                    List<Integer> list = new ArrayList<>();
                    // System.out.println(i + " " + s + " " + e);
                    list.add(nums[i]);
                    list.add(nums[s]);
                    list.add(nums[e]);
                    ans.add(list);

                    int temp = nums[e];
                    e = e - 1;
                    while (e - 1 > s && nums[e] == temp) {
                        e = e - 1;
                    }

                    temp = nums[s];
                    s = s + 1;
                    while(s + 1 < e && nums[s] == temp) {
                        s = s + 1;
                    }
                }
            }
            prev = nums[i];
        }
        return ans;
    }
}