class Solution {

    class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] ans = new int[m][n];
        boolean[][] v = new boolean[m][n];

        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            queue.add(new Node(i, 0));
            v[i][0] = true;
        }

        for(int j = 1; j < n; j++) {
            queue.add(new Node(0, j));
            v[0][j] = true;
        }

        bfs(queue, heights, v, ans);


        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(ans[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        boolean[][] v2 = new boolean[m][n];

        for(int j = 0; j < n;  j++) {
            queue.add(new Node(m - 1, j));
            v2[m-1][j] = true;
        }

        for(int i = 0; i < m -1; i++) {
            queue.add(new Node(i, n - 1));
            v2[i][n - 1] = true;
        }

        bfs(queue, heights, v2, ans);

        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(ans[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        List<List<Integer>> ret = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (ans[i][j] == 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ret.add(list);
                }
            }
        }


        return ret;
    }

    void bfs(Queue<Node> queue, int[][] heights, boolean[][] visited, int[][] ans) {

        int m = heights.length;
        int n = heights[0].length;

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            int i = node.x;
            int j = node.y;
            ans[i][j]++;

            if (i - 1 >= 0 && visited[i-1][j] == false && heights[i-1][j] >= heights[i][j]) {
                queue.add(new Node(i -1, j));
                visited[i-1][j] = true;
            }

            if (i + 1 < m && visited[i + 1][j] == false && heights[i + 1][j] >= heights[i][ j]) {
                queue.add(new Node(i + 1, j));
                visited[i+1][j] = true;
            }

            if (j - 1 >= 0 && visited[i][j - 1] == false && heights[i][j - 1] >= heights[i][j]) {
                queue.add(new Node(i, j - 1));
                visited[i][j-1] = true;
            }

            if (j + 1 < n && visited[i][j + 1] == false && heights[i][j+1] >= heights[i][j]) {
                queue.add(new Node(i, j + 1));
                visited[i][j + 1] = true;
            }
        }

    }
}