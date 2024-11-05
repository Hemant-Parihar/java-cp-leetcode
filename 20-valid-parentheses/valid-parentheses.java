class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.empty()) return false;
                if (ch == ')' && stack.peek() != '(') return false;
                if (ch == '}' && stack.peek() != '{') return false;
                if (ch == ']' && stack.peek() != '[') return false;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}