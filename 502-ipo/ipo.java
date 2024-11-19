class Solution {

    class Node{
        int p;
        int c;
        Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Node> capacity_less_pq = new PriorityQueue<Node>( (a, b) -> b.p - a.p);
        PriorityQueue<Node> capacity_greater_pq = new PriorityQueue<Node>( (a, b) -> a.c - b.c  );

        for(int i = 0; i < profits.length; i++) {
            if (capital[i] <= w) {
                capacity_less_pq.add(new Node(profits[i], capital[i] ));
            } else {
                capacity_greater_pq.add( new Node (profits[i], capital[i] ) );
            }
        }

        while(k > 0) {
            
            while (!capacity_greater_pq.isEmpty() && capacity_greater_pq.peek().c <= w ) {
                capacity_less_pq.add ( capacity_greater_pq.poll() );
            }

            if (capacity_less_pq.isEmpty()) break;

            Node node = capacity_less_pq.poll();
            
            w += (node.p );
            
            k--;
        }

        return w;
    }
}