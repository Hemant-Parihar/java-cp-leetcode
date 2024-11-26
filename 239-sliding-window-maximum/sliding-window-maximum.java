class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0, j = 0; j < nums.length; j++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);

            // System.out.println(deque);

            if (j - i + 1 == k) {
                ans[i] = deque.peek();
                if (deque.peekFirst() == nums[i]) {
                    deque.removeFirst();
                }
                i++;
            }
        }
        return ans;
    }
}