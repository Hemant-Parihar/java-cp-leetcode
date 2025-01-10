class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        int n = words1.length;
        int m = words2.length;

        int[][] l1 = new int[n][];

        for(int i = 0; i < n; i++) {
            String s = words1[i];
            int[] arr = new int[26];
            for(int j = 0; j < s.length(); j++) {
                arr[s.charAt(j) - 'a']++;
            }
            l1[i] = arr;
        }

        int[] max_f = new int[26];
        for(int i = 0; i < m; i++) {
            String s = words2[i];
            int[] arr = new int[26];
            for(int j = 0; j < s.length(); j++) {
                arr[s.charAt(j) - 'a']++;
            }
            
            for(int k = 0; k < 26; k++) {
                max_f[k] = Math.max(max_f[k], arr[k]);
            }
        }

        for(int i = 0; i < n; i++) {
            int[] arr = l1[i];
            if (compare(arr, max_f) == true) {
                ans.add(words1[i]);
            }
        }

        return ans;
    }

    boolean compare(int[] arr1, int[] arr2) {
        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));
        for(int i = 0; i < 26; i++) {
            if (arr1[i] < arr2[i]) return false;
        }
        return true;
    }
}