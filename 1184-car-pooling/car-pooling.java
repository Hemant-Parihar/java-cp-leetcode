class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> Integer.compare(a[2], b[2]) );

        for(int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int start = trip[1];

            while(!pq.isEmpty() && pq.peek()[2] <= start) {
                capacity += pq.poll()[0];
            }

            if (capacity >= trip[0]) {
                capacity -= trip[0];
                pq.add(trip);
            } else {
                return false;
            }
        }

        return true;
    }
}