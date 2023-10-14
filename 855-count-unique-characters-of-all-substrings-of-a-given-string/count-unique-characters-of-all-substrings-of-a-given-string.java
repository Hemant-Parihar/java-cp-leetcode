class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        Pair<Integer, Integer>[] pairList = new Pair[26];
        for(int i = 0; i < 26; i++) {
            pairList[i] = new Pair(0, 0);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'A';
            Pair<Integer, Integer> newPair = new Pair(i + 1, pairList[index].getKey());
            pairList[index] = newPair;
            for(int j = 0; j < 26; j++) {
                res += pairList[j].getKey() - pairList[j].getValue();
            }
        }
        return res;
    }
}