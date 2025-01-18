class Solution {
    public long minEnd(int n, int x) {
        long prev = x;
        int count = 1;
        while(count < n) {
            prev += 1;
            prev = prev | x;
            count++;
        }
        return prev;
    }
}