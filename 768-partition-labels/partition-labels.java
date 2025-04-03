class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] right = new int[26];
        Arrays.fill(right, -1);
        for(int i = 0; i < n; i++) {
            right[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        int i = 0;

        List<Integer> ans = new ArrayList<>();
        while(i < n) {
            char ch = s.charAt(i);
            end = Math.max(end, right[ch - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
                end = end + 1;
            }
            i++;
        }

        return ans;
    }
}