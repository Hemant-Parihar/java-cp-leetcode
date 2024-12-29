class StockSpanner {

    List<Integer> list;
    Stack<Integer> stack;
    public StockSpanner() {
        list = new ArrayList<>();
        stack = new Stack<>();
    }
    
    public int next(int price) {

        // System.out.println("=====Start=========");
        // System.out.println(list);
        // System.out.println(stack);
        
        while(!stack.isEmpty() && list.get(stack.peek()) <= price) {
            stack.pop();
        }

        list.add(price);

        int val;
        if (stack.isEmpty()) {
            val = list.size();
        } else {
            val = list.size() - stack.peek() - 1 ;
        }

        // System.out.println("=====end=========");

        // System.out.println(list);
        // System.out.println(stack);

        stack.add(list.size() - 1);

        return val;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */