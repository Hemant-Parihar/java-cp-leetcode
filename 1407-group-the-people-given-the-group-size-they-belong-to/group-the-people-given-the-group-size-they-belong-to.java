class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (groupSizes[i] == -1) continue;


            int val = groupSizes[i];
            List<Integer> list = new ArrayList<>();
            int count = 0;
            for(int j = i; j < n && count < val; j++) {
                if (groupSizes[j] == val) {
                    count++;
                    groupSizes[j] = -1;
                    list.add(j);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}