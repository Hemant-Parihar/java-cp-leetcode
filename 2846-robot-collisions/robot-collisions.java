class Solution {
    class Node {
        int p;
        int h;
        char dir;
        int index;
        Node(int p, int h, char dir, int i) {
            this.p = p;
            this.h = h;
            this.dir = dir;
            this.index = i;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add( new Node(positions[i], healths[i], directions.charAt(i), i) );
        }

        Collections.sort(list, (a, b) -> a.p - b.p);

        // we have sort the array based on the positions.
        Stack<Node> stack = new Stack<>();

        List<Node> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if (list.get(i).dir == 'L') {
                if (stack.isEmpty()) {
                    // this means there is no way this robot is going to collide.
                    ans.add(list.get(i));
                } else {
                    // there is a collision with the stack top and this element.
                    Node node = list.get(i);
                    int health = node.h;
                    boolean broken = false;
                    while(!stack.isEmpty()) {
                        if (stack.peek().h == health) {
                            // this means both of them will be removed.
                            stack.pop();
                            broken = true;
                            break;
                        } else if (stack.peek().h > health) {
                            // health of stack top will be decresed by 1.
                            stack.peek().h--;
                            broken = true;
                            break;
                        } else {
                            stack.pop();
                            health--;
                        }
                    }

                    if (broken == false) {
                        node.h = health;
                        ans.add(node);
                    }
                    
                }
            } else {
                stack.add(list.get(i));
            }
        }

        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        Collections.sort(ans, (a, b) -> a.index - b.index);

        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < ans.size(); i++) {
            ret.add(ans.get(i).h);
        }

        return ret;
    }
}