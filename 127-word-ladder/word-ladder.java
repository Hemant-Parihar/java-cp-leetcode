class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();

        Queue<String> queue = new LinkedList<>();
        HashSet<String> done = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if (matched(beginWord, wordList.get(i))) {
                queue.add(wordList.get(i));
                done.add(wordList.get(i));
            }
        }

        int len = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for(int i = 0; i < size; i++) {
                String str = queue.poll();

                if (str.equals(endWord)) return len;

                for(int j = 0; j < n; j++) {
                    if (!done.contains(wordList.get(j)) && matched(str, wordList.get(j))) {
                        done.add(wordList.get(j));
                        queue.add(wordList.get(j));
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