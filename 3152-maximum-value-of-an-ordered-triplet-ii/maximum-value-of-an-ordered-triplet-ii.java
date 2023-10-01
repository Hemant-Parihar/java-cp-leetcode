class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int min = nums[0];
        int max = nums[0];
    
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < list.size(); j++) {
                int diff = list.get(j).getKey() - list.get(j).getValue();
                ans = Math.max(ans, (long)diff*nums[i]);
            }
            ans = Math.max(ans, (long)(max - min)*nums[i]);
            if (nums[i] < min) {
                List<Pair<Integer, Integer>> newList = new ArrayList<>();
                for(int j = 0; j< list.size(); j++) {
                    if (list.get(j).getValue() < min) {
                        newList.add(list.get(j));
                    }
                }
                list = newList;
                min = nums[i];
            } else if (nums[i] > max) {
                int diff = max - min;
                if (diff > 0)
                    list.add(new Pair(max, min));
                max = nums[i];
                min = nums[i];
            }
        }
        return ans;
    }
}