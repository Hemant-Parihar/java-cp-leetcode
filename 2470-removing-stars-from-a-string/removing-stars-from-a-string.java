class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }


        StringBuilder str = new StringBuilder();
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}