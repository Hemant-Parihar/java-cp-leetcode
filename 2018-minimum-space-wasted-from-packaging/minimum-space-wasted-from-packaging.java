class Solution {
    int MOD = 1000000007;
    public int minWastedSpace(int[] packages, int[][] boxes) {
        int n = packages.length;
        int m = boxes.length;
        long ans = Long.MAX_VALUE;
        Arrays.sort(packages);

        long[] prefixSum = new long[n + 1];

        int[] maxBoxes = new int[m];
        for(int k = 0; k < m; k++) {
            int max = 0;
            for(int i = 0; i < boxes[k].length; i++) {
                max = Math.max(max, boxes[k][i]);
            }
            maxBoxes[k] = max;
        }

        int maxOfPackages = 0;
        prefixSum[0] = 0;
        for(int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + packages[i-1];
            maxOfPackages = Math.max(maxOfPackages, packages[i-1]);
        }


        for(int k = 0; k < m; k++) {
            if (maxOfPackages > maxBoxes[k]) continue;

            Arrays.sort(boxes[k]);
            int used_idx = -1;
            long sub_ans = 0;

            for(int i = 0; i < boxes[k].length; i++) {
                int box = boxes[k][i];
                int idx = Arrays.binarySearch(packages, box);
                // System.out.println(idx);
                if (idx < 0) {
                    idx = Math.abs(idx) - 2;
                }
                while(idx != -1 && packages[idx] == box && idx + 1 < n && packages[idx + 1] == box) {
                    idx++;
                }
                if (idx == n) idx--;
                long total = (long)boxes[k][i] * (long)(idx - used_idx);
                long sum = prefixSum[idx + 1] - prefixSum[used_idx + 1];
                sub_ans = (sub_ans + (total - sum));
                System.out.println(idx + " " + used_idx + " " + total + " " + sum + " " + sub_ans);
                used_idx = idx;
            }

            

            ans = Math.min(ans, sub_ans);
            ans = ans % MOD;
        }
        return ans == Long.MAX_VALUE ? -1 : (int)ans;
    }
}