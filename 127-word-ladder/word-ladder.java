class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }

        if (!set.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> v = new HashSet<>();

        v.add(beginWord);
        queue.add(beginWord);

        int level = 1;

        while( !queue.isEmpty() ) {
            int size = queue.size();
            level++;

            for(int k = 0; k < size; k++) {
                String s = queue.remove();
                StringBuilder str = new StringBuilder(s);

                for(int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    for(int j = 0; j < 26; j++) {
                        str.setCharAt(i, (char) ('a' + j) );

                        if (str.toString().equals(endWord)) {
                            return level;
                        }

                        if (set.contains(str.toString()) && !v.contains(str.toString()) ) {
                            v.add(str.toString());
                            queue.add(str.toString());
                        }
                    }
                    str.setCharAt(i, ch);
                }
            }

        }

        return 0;
    }
}