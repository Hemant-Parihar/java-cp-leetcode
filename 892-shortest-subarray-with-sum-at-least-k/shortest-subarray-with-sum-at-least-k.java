class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
        int[] nsl = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prefixSum[stack.peek()] > prefixSum[i]) {
                nsl[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            nsl[stack.pop()] = n;
        }
        // System.out.println(Arrays.toString(prefixSum));
        // System.out.println(Arrays.toString(nsl));

        // for(int i = 0; i < n; i++) {
        //     System.out.println(nums[i] + " " + prefixSum[i] + " " + nsl[i]);
        // }

        int i = 0;
        int j = 0;
        long sum = 0;
        int ans = n + 1;

        while(j <= n) {
            if (ans == 1) break;

            if (j != n && sum < k) {
                sum += nums[j];
                j++;
                if (sum <= 0) {
                    i = j;
                    sum = 0;
                }
            } else {
                // System.out.println("start " + i + " " + j + " " + sum);

                while(i < j && (sum >= k || (i > 0 && nsl[i - 1] < j))) {
                    if (sum >= k) {
                        // System.out.println(i + " " + j);
                        ans = Math.min(ans, j - i);
                        i++;
                    } else {
                       if (i > 0 && nsl[i-1] < j) {
                            i = nsl[i-1] + 1;
                        }
                    }

                    if (i == 0) {
                        sum = prefixSum[j-1];
                    } else {
                        sum = prefixSum[j-1] - prefixSum[i - 1];
                    }
                    
                    // System.out.println(i + " " + sum);
                }

                // System.out.println("end " + i + " " + j + " " + sum);

                if (j == n) {
                    break;
                }

            }
        }

        return ans == n + 1 ? - 1 : ans;
    }
}