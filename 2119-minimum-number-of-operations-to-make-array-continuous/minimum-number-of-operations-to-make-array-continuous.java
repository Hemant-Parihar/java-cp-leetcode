class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int diff = n - 1;
        int ans = Integer.MAX_VALUE;
        int val = 0;
        HashSet<Integer> setG = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (setG.contains(nums[i])) {
                val++;
            } else {
                list.add(nums[i]);
                setG.add(nums[i]);
            }
        }

        Collections.sort(list);

        int prev = -1;
        for(int i = 0; i < list.size(); i++) {

            if (nums[i] == prev) continue;

            int min = list.get(i);
            int temp_ans = i;


            int index = Collections.binarySearch(list, min + diff);
            if (index < 0) {
                index = -index;
                temp_ans += list.size() - (index - 1);
            } else {
                temp_ans += list.size() - (index + 1);
            }
            
            prev = list.get(i);
            ans = Math.min(ans, val + temp_ans);
        }

        return ans;
    }
}