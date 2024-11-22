class Solution {

    class Node {
        int start;
        int end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
    

        List<Node> list = new ArrayList<>();

        for(int i = 0; i < people.length; i++) {
            list.add( new Node(people[i], i) );
        }

        Collections.sort(list, (a, b) -> a.start - b.start);


        int[] ans = new int[people.length];

        int index = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>( (a, b) -> a.end - b.end );

        for(int i = 0; i < people.length; i++) {
            int t = list.get(i).start;


            while(index < flowers.length  ) {

                if ( t >= flowers[index][0] && t > flowers[index][1] ) {
                    index++;
                    continue;
                } else if ( t >= flowers[index][0] && t <= flowers[index][1] ) {
                    queue.add( new Node(flowers[index][0], flowers[index][1]) );
                    index++;
                } else {
                    break;
                }
            
            }

            while(!queue.isEmpty() && t > queue.peek().end) {

                queue.poll();

            }

            ans[ list.get(i).end ] = queue.size();
            
        }

        // System.out.println(Arrays.toString(ans));

        return ans;
    }
}