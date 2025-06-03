class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();

        HashSet<String> wordSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        HashSet<String> done = new HashSet<>();

        wordSet.addAll(wordList);

        queue.add(beginWord);
        done.add(beginWord);

        int len = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for(int i = 0; i < size; i++) {
                String str = queue.poll();

                if (str.equals(endWord)) return len;

                char[] charArr = new char[str.length()];
                for(int j = 0; j < str.length(); j++) {
                    charArr[j] = str.charAt(j);
                }

                for(int j = 0; j < str.length(); j++) {
                    char ch = charArr[j];
                    for(int k = 0; k < 26; k++) {
                        if (ch != (char)('a' + k)) {
                            charArr[j] = (char)('a' + k);
                            String newStr = new String(charArr);
                            if (wordSet.contains(newStr) && !done.contains(newStr)) {
                                queue.add(newStr);
                                done.add(newStr);
                            }
                            charArr[j] = ch;
                        }
                    }
                }
            }
        }

        return 0;
    }

    boolean matched(String s1, String s2) {
        int diff = 0;
        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1 ? true : false;
    }
}