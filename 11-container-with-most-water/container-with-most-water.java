class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        List<Pair<Integer, Integer>> front = new ArrayList<>();

        front.add(new Pair(0, height[0]));

        int ans = 0;
        for(int i = 1; i < height.length; i++) {
            int size = front.size();
            for(int j = size - 1; j >= 0; j--) {
                int index = front.get(j).getKey();

                int temp_ans = (i - index ) * Math.min(height[i], height[index]);
                ans = Math.max(ans, temp_ans);
            }

            if (front.get(size - 1).getValue() < height[i]) {
                front.add(new Pair(i, height[i]));
            }
        }

        List<Pair<Integer, Integer>> back = new ArrayList<>();

        back.add(new Pair(n - 1, height[n - 1]));

        for(int i = n - 2; i >= 0; i--) {
            int size = back.size();
            for(int j = size - 1; j >= 0; j--) {
                int index = back.get(j).getKey();

                int temp_ans = ( index  - i) * Math.min(height[i], height[index]);
                ans = Math.max(ans, temp_ans);
            }
            
            if (back.get(size - 1).getValue() < height[i]) {
                back.add(new Pair(i, height[i]));
            }   
        }

        return ans;
    }
}