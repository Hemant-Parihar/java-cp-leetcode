class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean val = dfs(i, j, board, word, 0);
                if (val == true) return true;
            }
        }
        return false;
    }

    boolean dfs(int i, int j, char[][] board, String word, int k) {
        if (k == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
         || board[i][j] == '.' || board[i][j] != word.charAt(k)) return false;

        char temp = board[i][j];
        board[i][j] = '.';
        boolean val = false;
        val = dfs(i + 1, j, board, word, k + 1);
        if (val == true) return true;
        val = dfs(i - 1, j, board, word, k + 1);
        if (val == true) return true;
        val = dfs(i, j + 1, board, word, k + 1);
        if (val == true) return true;
        val = dfs(i, j - 1, board, word, k + 1);
        if (val == true) return true;

        board[i][j] = temp;
        return false;
    }


}