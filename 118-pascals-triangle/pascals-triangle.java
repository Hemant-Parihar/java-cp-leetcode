class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 1;
        ans.add(new ArrayList<>(List.of(1)));
        while(count < numRows) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> prev = ans.get(ans.size() - 1);
            for(int i = 0; i < prev.size() - 1; i++) {
                list.add(prev.get(i) + prev.get(i + 1));
            }
            list.add(1);
            ans.add(list);
            count++;
        }
        return ans;
    }
}