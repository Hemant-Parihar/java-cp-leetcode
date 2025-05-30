class Solution {
    public int[][] insert(int[][] arr, int[] interval) {
        int n = arr.length;
        List<int[]> list = new ArrayList<>();

        boolean added = false;

        for(int i = 0; i < n; i++) {
            if ( (arr[i][1] < interval[0]) || added ) {
                list.add(arr[i]);
            } else if ( arr[i][0] > interval[1] && added == false) {
                list.add(interval);
                added = true;
                i--;
            } else {
                // there is an overlap.
                interval[0] = Math.min(arr[i][0], interval[0]);
                interval[1] = Math.max(arr[i][1], interval[1]);
            }
        }

        if (added == false) {
            list.add(interval);
        }

        int m = list.size();
        int[][] ans = new int[m][2];

        for(int i = 0; i < m; i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;
    }
}