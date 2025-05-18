class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int[] node = new int[2];
            node[0] = sum_of_digits(nums[i]);
            node[1] = nums[i];
            list.add(node);
        }

        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int[] node = list.get(i);
            map.put(node[1], i);
        }

        // for(int i = 0; i < n; i++) {
        //     System.out.print(list.get(i)[1] + " ");
        // }
        // System.out.println();

        // System.out.println(map);

        int ans = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if (set.contains(nums[i]) == true) continue;
            int c_len = 1;
            int val = nums[i];
            set.add(val);
            int next_index = map.get(val);

            while(nums[i] != nums[next_index]) {
                // System.out.println(next_index);
                val = nums[next_index];
                next_index = map.get(val);
                c_len++;
                set.add(val);
            }

            ans += c_len - 1;
        }

        return ans;
        
    }

    int sum_of_digits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}