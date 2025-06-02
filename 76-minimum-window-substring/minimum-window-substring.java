class Solution {
    public String minWindow(String s, String t) {
        int m = t.length();
        int[] arr = new int[128];
        for(char ch : t.toCharArray()) {
            arr[ch]++;
        }

        int count = 0;
        int i = 0;
        int j;
        int len = Integer.MAX_VALUE;
        String ans = "";

        for(j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (arr[ch] > 0) {
                count++;
            }
            arr[ch]--;
            while (count == m) {
                if (len > (j - i + 1)) {
                    len = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
                char ch_p = s.charAt(i);
                arr[ch_p]++;
                if (arr[ch_p] > 0) {
                    count--;
                }
                i++;
            }
        }


        return ans;
    }
}