class Solution {
    int mod = 1000000007;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arr[i], 1L);
        }

        
        for(int i = 0; i < n; i++) {
            long temp_ans = 1;
            for(int j = 0; j < i; j++) {
                if ( arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j] ) ) {
                    int val = arr[i] / arr[j];
                    if (val == arr[j]) {
                        temp_ans += map.get(val) * map.get(val);
                        temp_ans %= mod;
                    } else if (val > arr[j]) {
                        temp_ans += 2 * map.get(arr[j]) * map.get(val) ;
                        temp_ans %= mod;
                    }
                }
            }
            map.put(arr[i], temp_ans);
        }

        // System.out.println(map);

        int ans = 0;
        for(long val : map.values()) {
            ans += (int)val;
            ans %= mod;
        }

        return ans;
    }
}