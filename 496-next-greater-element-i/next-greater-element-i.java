class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = stack.peek();
            }
            stack.add(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            for(int j = 0; j < n; j++) {
                if (nums2[j] == val) {
                    ans[i] = nge[j];
                    break;
                }
            }
        }

        return ans;
    }
}