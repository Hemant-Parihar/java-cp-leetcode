class Solution {
    int mod = 1000000007;
    public int maxSum(List<Integer> nums, int k) {
        int n = nums.size();
        int[] freq = new int[32];

        for(int i = 0; i < n; i++) {
            int num = nums.get(i);
            for(int j = 0; j < 31; j++) {
                if ( (num & (1 << j)) > 0) {
                    freq[j]++;
                }
            }
        }

        long sum = 0;
        for(int i = 0; i < k; i++) {
            long x = 0;
            for(int j = 31; j >= 0; j--) {
                if (freq[j] > 0) {
                    x += (1 << j);
                    freq[j]--;
                }
            }
            sum += x * x;
            sum %= mod;
        }

        return (int)sum;
    }
}