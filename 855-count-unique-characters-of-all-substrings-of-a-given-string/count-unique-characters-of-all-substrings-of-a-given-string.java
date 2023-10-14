class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[][] pairList = new int[26][2];

        int res = 0;
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'A';
            pairList[index][1] = pairList[index][0];
            pairList[index][0] = i + 1;
            for(int j = 0; j < 26; j++) {
                res += pairList[j][0] - pairList[j][1];
            }
        }
        return res;
    }
}