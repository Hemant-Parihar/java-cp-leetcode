class Solution {

    int N;
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        N = n;
        int ans = 0;

        HashMap<Integer, Integer> areaIndex = new HashMap<>();
        int count = 2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid, count);
                    areaIndex.put(count, area);
                    ans = Math.max(ans, area);
                    count++;
                }
            }
        }

        System.out.println(areaIndex);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> seen = new HashSet<>();
                    int temp_ans = 1;
                    for( Pair<Integer, Integer> p: Valid(i, j) ) {
                        int index = grid[p.getKey()][p.getValue()];
                        if (index > 1 && !seen.contains(index)) {
                            temp_ans += areaIndex.get(index);
                            seen.add(index);
                        }
                    }
                    ans = Math.max(ans, temp_ans);
                }
            }
        }

        return ans;
    }

    List<Pair<Integer, Integer>> Valid(int x, int y) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        if (x - 1 >= 0) list.add(new Pair(x - 1, y));
        if (y - 1 >= 0) list.add(new Pair(x, y - 1));
        if (x + 1 < N) list.add(new Pair(x + 1, y));
        if (y + 1 < N) list.add(new Pair(x, y + 1));
        return list;
    }

    int dfs(int i, int j, int[][] grid, int val) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == val || grid[i][j] == 0) {
            return 0;
        }
        int count = 1;
        grid[i][j] = val;
        count += dfs(i + 1, j, grid, val);
        count += dfs(i - 1, j, grid, val);
        count += dfs(i, j + 1, grid, val);
        count += dfs(i, j - 1, grid, val);
        return count;
    }

}