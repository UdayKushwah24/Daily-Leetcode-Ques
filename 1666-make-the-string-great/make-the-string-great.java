class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++ ) {
            char ch = s.charAt(i);
            if(!stack.isEmpty() && stack.peek()+32 == ch) {
                stack.pop();
            } 
            else if(!stack.isEmpty() && stack.peek() == ch+32) {
                stack.pop();
            }  else {
                stack.push(ch);
            }

        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}