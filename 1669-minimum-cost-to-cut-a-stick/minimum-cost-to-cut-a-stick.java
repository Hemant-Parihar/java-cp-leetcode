class Solution {
    public int minCost(int n, int[] cuts) {

        HashMap<String, Integer> map = new HashMap<>();
        return solve(0, n, cuts, map);
    }

    int solve(int i, int j, int[] cuts, HashMap<String, Integer> map) {
        if (j - i <= 1)
            return 0;

        String str = i + "-" + j;
        if ( map.containsKey(str) ) return map.get(str);

        int ans = Integer.MAX_VALUE;

        for(int k = 0; k < cuts.length; k++) {
            if (cuts[k] > i && cuts[k] < j) {
                int temp_ans = (j - i) + solve(i, cuts[k], cuts, map) + solve(cuts[k], j, cuts, map);
                ans = Math.min(ans, temp_ans);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }
        map.put(str, ans);
        return ans;
    }
}