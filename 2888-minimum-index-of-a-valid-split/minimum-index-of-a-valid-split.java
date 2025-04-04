class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if (map.containsKey(nums.get(i))) {
                map.put(nums.get(i), map.get(nums.get(i)) + 1);
            } else {
                map.put(nums.get(i), 1);
            }
        }

        int f = 0;
        int val = -1;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > f) {
                f = entry.getValue();
                val = entry.getKey();
            }
        }

        int[] l = new int[n];
        int[] r = new int[n];

        int count = 0;
        for(int i = 0; i < n; i++) {
            if (nums.get(i) == val) {
                count++;
            }
            l[i] = count;
        }

        count = 0;
        for(int i = n - 1; i >= 0; i--) {
            if (nums.get(i) == val) {
                count++;
            }
            r[i] = count;
        }

        for(int i = 0; i < n - 1; i++) {
            if (l[i] > ( (i + 1) / 2) && r[i + 1] > (n - i - 1) / 2 ) return i;
        }
        return -1;
    }
}