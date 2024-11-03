
class Solution {

    HashSet<String> set = new HashSet<>();
    HashSet<String> ansSet = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        for(int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, new StringBuilder());
            }
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(ansSet);
        return list;
    }

    void dfs(int i, int j, char[][] board, StringBuilder str) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
            || board[i][j] == '.' || str.length() > 10) return;

        char ch = board[i][j];
        str.append(ch);
        board[i][j] = '.';
        
        String s = str.toString();
        if ( set.contains(s) ) {
            ansSet.add(s);
        }

        dfs(i + 1, j, board, str);
        dfs(i - 1, j, board, str);
        dfs(i, j + 1, board, str);
        dfs(i, j - 1, board, str);

        str.deleteCharAt(str.length() - 1);
        board[i][j] = ch;
    }

}