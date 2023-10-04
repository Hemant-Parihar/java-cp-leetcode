class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ansList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int prev_i = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if (prev_i == nums[i]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int prev_j = Integer.MIN_VALUE;

            for(int j = i + 1; j < n; j++) {
                if (prev_j == nums[j]) {
                    continue;
                }

                if (nums[i] + nums[j] > 0) {
                    break;
                }

                int val = - (nums[i] + nums[j]);
                if (val < nums[j]) continue;

                if (nums[i] == nums[j] && nums[j] == val) {
                    if (map.get(val) >= 3) {
                        ansList.add(new ArrayList<>(List.of(nums[i], nums[j], val)));
                    }
                } else if (nums[j] == val) {
                    if (map.get(val) >= 2) {
                        ansList.add(new ArrayList<>(List.of(nums[i], nums[j], val)));
                    }
                } else {
                    if (map.containsKey(val)) {
                        ansList.add(new ArrayList<>(List.of(nums[i], nums[j], val)));
                    }
                }

                prev_j = nums[j];
            }
            prev_i = nums[i];
        }

        return ansList;
    }
}