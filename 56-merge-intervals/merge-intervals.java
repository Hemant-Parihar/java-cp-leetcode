class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();

        int[] node = new int[2];
        node[0] = intervals[0][0];
        node[1] = intervals[0][1];

        for(int i = 1; i < n; i++) {
            if (intervals[i][0] <= node[1]) {
                // there is an overlap.
                node[0] = Math.min(node[0], intervals[i][0]);
                node[1] = Math.max(node[1], intervals[i][1]);
            } else {
                list.add(new int[]{node[0], node[1]});
                node[0] = intervals[i][0];
                node[1] = intervals[i][1];
            }
        }

        list.add(new int[]{node[0], node[1]});
        int m = list.size();

        int[][] ans = new int[m][2];

        for(int i = 0; i < m; i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;
    }
}