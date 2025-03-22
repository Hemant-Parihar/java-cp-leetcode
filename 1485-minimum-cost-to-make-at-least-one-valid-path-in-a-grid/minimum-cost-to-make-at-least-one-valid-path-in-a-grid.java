class Solution {

    class Node {
        int x, y, dis;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.dis = cost;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true; // Check if both references are the same
            if (obj == null || getClass() != obj.getClass()) return false; // Ensure obj is a Node

            Node node = (Node) obj; // Typecast obj to Node
            return this.x == node.x && this.y == node.y && this.dis == node.dis;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, dis);
        }
    }

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> a.dis - b.dis );
        HashSet<Node> set = new HashSet<>();

        Node newNode = new Node(0, 0, 0);
        pq.add(newNode);
        

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.x == m - 1 && node.y == n - 1) return node.dis;

            if (node.x - 1 >= 0) {
                if (grid[node.x][node.y] == 4) {
                    Node next = new Node(node.x - 1, node.y, node.dis);
                    if (!set.contains(next)) {
                        pq.add( next );
                        set.add(next);
                    }
                } else {
                    Node next = new Node(node.x - 1, node.y, node.dis + 1);
                    if (!set.contains(next)) {
                        pq.add( next );
                        set.add(next);
                    }
                }
            }

            if (node.x + 1 < m) {
                if (grid[node.x][node.y] == 3) {
                    Node next = new Node(node.x + 1, node.y, node.dis);
                    if (!set.contains(next)) {
                        pq.add( next );
                        set.add(next);
                    }
                } else {
                    Node next = new Node(node.x + 1, node.y, node.dis + 1);
                    if (!set.contains(next)) {
                        pq.add( next );
                        set.add(next);
                    }
                }
            }

            if (node.y - 1 >= 0) {
                if (grid[node.x][node.y] == 2) {
                    Node next = new Node(node.x, node.y - 1, node.dis);
                    if (!set.contains(next)) {
                        pq.add( next );
                        set.add(next);
                    }
                } else {
                    Node next = new Node(node.x, node.y - 1, node.dis + 1);
                    if (!set.contains(next)) {
                        pq.add( next );
                        set.add(next);
                    }
                }
            }

            if (node.y + 1 < n) {
                if (grid[node.x][node.y] == 1) {
                    Node next = new Node(node.x, node.y + 1, node.dis);
                    if (!set.contains(next)) {
                        pq.add( next );
                        set.add(next);
                    }
                } else {
                    Node next = new Node(node.x, node.y + 1, node.dis + 1);
                    if (!set.contains(next)) {
                        pq.add( next );
                        set.add(next);
                    }
                }
            }

        }

        return -1;
    }
}