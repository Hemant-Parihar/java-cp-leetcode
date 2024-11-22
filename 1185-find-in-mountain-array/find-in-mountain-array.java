/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int N = mountainArr.length();

        int peak = findPeak(mountainArr, 0, N-1);
        int elementAtPeak = mountainArr.get(peak);
        int ans = -1;
        
        if (target == elementAtPeak) {
            return peak;
        }
        
        ans = binarySearch(mountainArr, target, 0, peak-1, true);
        if (ans == -1) {
            ans = binarySearch(mountainArr, target, peak+1, N-1, false);
        }
        return ans;
    }

    int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean asc) {
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            }
            if (asc) {
                if (midValue < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midValue < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    int findPeak(MountainArray mountainArr, int left, int right) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}