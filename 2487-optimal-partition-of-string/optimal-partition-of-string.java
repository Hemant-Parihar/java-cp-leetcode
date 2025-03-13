class Solution {
    public int partitionString(String s) {
        int ans = 0;
        int n = s.length();
        int[] arr = new int[26];

        for(int i = 0; i < n; i++) {
            if (arr[s.charAt(i) - 'a'] > 0) {
                ans++;
                Arrays.fill(arr, 0);
            }
            arr[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                ans++;
                break;
            }
        }
        return ans;
    }
}