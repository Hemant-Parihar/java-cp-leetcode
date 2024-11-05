class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i_start = 0;
        int i_end = m - 1;
        int j_start = 0;
        int j_end = n - 1;

        char dir = 'R';

        List<Integer> list = new ArrayList<>();

        while(i_start <= i_end && j_start <= j_end) {
            if (dir == 'R') {
                // we have to move right.
                for(int j = i_start; j <= j_end; j++) {
                    list.add(matrix[i_start][j]);
                }

                i_start++;
                dir = 'D';
            } else if (dir == 'D') {
                // we have to move down from i_start;
                for(int i = i_start; i <= i_end; i++) {
                    list.add(matrix[i][j_end]);
                }

                j_end--;
                dir = 'L';
            } else if (dir == 'L') {
                // we have to move left from j_end;

                for(int j = j_end; j >= j_start; j--) {
                    list.add(matrix[i_end][j]);
                }

                i_end--;
                dir = 'U';
            } else if (dir == 'U') {
                // we have to move up from i_end;

                for(int i = i_end; i >= i_start; i--) {
                    list.add(matrix[i][j_start]);
                }

                j_start++;
                dir = 'R';
            }
        }

        return list;
    }
}