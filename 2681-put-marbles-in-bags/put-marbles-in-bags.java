class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;

        int[] sumArr = new int[n - 1];
        for(int i = 0; i < n - 1; i++) {
            sumArr[i] = weights[i] + weights[i + 1];
        }
        // System.out.println(Arrays.toString(sumArr));
        Arrays.sort(sumArr);

        long min = 0;
        for(int i = 0; i < k - 1; i ++) {
            min += sumArr[i];
        }
        long max = 0;
        int count = 0;
        int i = n - 2;
        while(count < k - 1) {
            max += sumArr[i];
            i--;
            count++;
        }
        // System.out.println(Arrays.toString(sumArr));
        // System.out.println(min + " " + max);
        return max - min;
    }
}