class Solution {
    public int earliestAcq(int[][] logs, int n) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        int time = 0;
        for(int i = 0; i < logs.length; i++) {
            int a = logs[i][1];
            int b = logs[i][2];

            int parent_a = findParent(a, parent);
            int parent_b = findParent(b, parent);

            if (parent_a != parent_b) {
                time = logs[i][0];
                if (rank[parent_a] >= rank[parent_b]) {
                    parent[parent_b] = parent_a;
                    rank[parent_a] = rank[parent_a] + rank[parent_b];
                } else {
                    parent[parent_a] = parent_b;
                    rank[parent_b] = rank[parent_a] + rank[parent_b];
                }
            }
        }

        int par = findParent(0, parent);
        for(int i = 1; i < n; i++) {
            if (par != findParent(i, parent)) return -1;
        }

        return time;
    }

    int findParent(int i, int[] parent) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }
}