class Solution {

    class Node {
        int time;
        int num;
        Node(int t, int n) {
            this.time = t;
            this.num = n;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] count = new int[n];
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            free.add(i);
        }

        PriorityQueue<Node> notFree = new PriorityQueue<>( (a, b) -> {
            if ( (a.time - b.time) == 0) {
                return a.num - b.num;
            } else {
                return a.time - b.time;
            }
        });


        for(int i = 0; i < meetings.length; i++) {

            int startTime = meetings[i][0];
            int endTime = meetings[i][1];

            while(!notFree.isEmpty() && notFree.peek().time <= startTime) {
                Node node = notFree.poll();
                free.add(node.num);
            }

            if (!free.isEmpty()) {
                int roomNum = free.poll();
                notFree.add(new Node(endTime, roomNum));
                count[roomNum]++;
            } else {
                // we need to wait, as no free room is available.
                // when will the room be free again.
                Node node = notFree.poll();
                int start = node.time;
                int end = start + (endTime - startTime);
                count[node.num]++;
                notFree.add(new Node(end, node.num));
            }

        }

        int max = -1;
        int index = -1;
        for(int i = 0; i < n; i++) {
            if (count[i] > max) {
                index = i;
                max = count[i];
            }
        }

        return index;
    }
}