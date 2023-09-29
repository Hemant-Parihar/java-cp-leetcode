class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int val = digits(nums[i]);
            if (map.containsKey(val)) {
                map.get(val).add(nums[i]);
            } else {
                map.put(val, new ArrayList<>(List.of(nums[i])));
            }
        }
        int ans = -1;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() >= 2) {
                int size = list.size();
                ans = Math.max(ans, list.get(size - 1) + list.get(size - 2));
            }
        }

        return ans;
    }

    int digits(int num) {
        int count = 0;
        while(num > 0) {
            count += num % 10;
            num /= 10;
        }
        return count;
    }
}