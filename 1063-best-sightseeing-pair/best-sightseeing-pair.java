class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] num = new int[n];
        int[] max = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            num[i] = values[i] - i;
            if (i != n - 1) {
                max[i] = Math.max(max[i + 1], num[i]);
            } else {
                max[i] = num[i];
            }
        }

        int ans = Integer.MIN_VALUE;

        // System.out.println(Arrays.toString(num));
        // System.out.println(Arrays.toString(max));

        for(int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, i + values[i] + max[i + 1]);
        }

        return ans;
    }
}