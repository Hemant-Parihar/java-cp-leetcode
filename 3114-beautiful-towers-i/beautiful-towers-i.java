class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long ans = 0;

        long[] left = new long[n];
        long[] right = new long[n];

        left[0] = maxHeights.get(0);
        for(int i = 1; i < n; i++) {
            if (maxHeights.get(i) >= maxHeights.get(i - 1)) {
                left[i] = left[i-1] + maxHeights.get(i);
            } else {
                left[i] = findLeft(i, maxHeights, left);
            }
        }

        right[n-1] = maxHeights.get(n - 1);
        for(int i = n - 2; i >= 0; i--) {
            if (maxHeights.get(i) >= maxHeights.get(i + 1) ) {
                right[i] = right[i+1] + maxHeights.get(i);
            } else {
                right[i] = findRight(i, maxHeights, right);
            }
        }

        for(int i = 0; i < n -1; i++) {
            ans = Math.max(ans, left[i] + right[i + 1]);
        }

        ans = Math.max(ans, right[0]);
        ans = Math.max(ans, left[n-1]);

        return ans;
    }

    long findLeft(int j, List<Integer> maxHeights, long[] left) {
        long value = maxHeights.get(j);
        int max = maxHeights.get(j);
        j--;
        while(j >= 0) {
            if (maxHeights.get(j) == max) {
                value += left[j];
                break;
            }
            value += Math.min(maxHeights.get(j), max);
            max = Math.min(maxHeights.get(j), max);
            j--;
        }
        return value;
    }

    long findRight(int i, List<Integer> maxHeights, long[] right) {
        long value = maxHeights.get(i);
        int max = maxHeights.get(i);
        for(int j = i + 1; j < maxHeights.size(); j++) {
            if (maxHeights.get(j) == max) {
                value += right[j];
                break;
            }
            value += Math.min(maxHeights.get(j), max);
            max = Math.min(maxHeights.get(j), max);
        }
        return value;
    }
}