class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        List<Integer> front = new ArrayList<>();

        front.add(0);

        int ans = 0;
        for(int i = 1; i < height.length; i++) {
            int size = front.size();
            for(int j = size - 1; j >= 0; j--) {
                int index = front.get(j);
                int temp_ans = (i - index ) * Math.min(height[i], height[index]);
                ans = Math.max(ans, temp_ans);
            }
            if (height[front.get(size - 1)] < height[i]) {
                front.add(i);
            }
        }

        List<Integer> back = new ArrayList<>();

        back.add(n - 1);

        for(int i = n - 2; i >= 0; i--) {
            int size = back.size();
            for(int j = size - 1; j >= 0; j--) {
                int index = back.get(j);
                int temp_ans = ( index  - i) * Math.min(height[i], height[index]);
                ans = Math.max(ans, temp_ans);
            }
            
            if (height[back.get(size - 1)] < height[i]) {
                back.add(i);
            }   
        }

        return ans;
    }
}