class TreeAncestor {

    int N;
    int[][] table;

    int MAX_ROW = 17;

    public TreeAncestor(int n, int[] parent) {
        N = n;
        table = new int[MAX_ROW][n];
        for(int i = 0; i < n; i++) {
            table[0][i] = parent[i];
        }

        for(int i = 1; i < MAX_ROW; i++) {
            for(int j = 0; j < n; j++) {
                if (table[i-1][j] == -1) {
                    table[i][j] = -1;
                } else {
                    table[i][j] = table[i-1][table[i-1][j]];
                }
            }
        }

        for(int i = 0; i < MAX_ROW; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int mask;
        for(int i = 0; i < MAX_ROW; i++) {
            mask = 1 << i;
            if (mask > k) return node;
            if ( (k & mask) >= 1) {
                node = table[i][node];
                if (node == -1) return node;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */