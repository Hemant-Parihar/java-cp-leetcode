class Solution {
    public int findMinFibonacciNumbers(int k) {
        int f1 = 1;
        int f2 = 1;

        if (k == 1) return 1;

        while(k > f2) {
            int temp = f2;
            f2 = f2 + f1;
            f1 = temp;

            if (k == f2) return 1;
        }

        k = k - f1;
        return 1 + findMinFibonacciNumbers(k);
    }
}