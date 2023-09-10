class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int diff1 = Math.abs(fx - sx);
        int diff2 = Math.abs(fy - sy);
        if (Math.max(diff1, diff2) == 0 && t == 1) return false;
        return Math.max(diff1, diff2) <= t ? true : false;
    }
}