class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Pair<Integer, Integer>> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            arr.add(new Pair<>(nums[i], i));
        }
        Collections.sort(arr, (a, b) -> a.getKey() - b.getKey());
        int s = 0;
        int b = nums.length - 1;
        while(s < b) {
            if (arr.get(s).getKey() + arr.get(b).getKey() > target) {
                b--;
            } else if (arr.get(s).getKey() + arr.get(b).getKey() < target) {
                s++;
            } else {
                return new int[]{ arr.get(s).getValue(), arr.get(b).getValue() };
            }
        }
        return null;
    }
}