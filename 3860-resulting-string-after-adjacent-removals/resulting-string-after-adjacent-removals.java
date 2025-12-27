class Solution {
    public String resultingString(String s) {
         Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char prev = ' ';
            if (!stack.isEmpty()) {
                prev = stack.peek();
            }
            if (!stack.isEmpty() && ((ch == prev+1) || (ch+1 == prev) || (ch == 'a' && prev == 'z')||ch == 'z' && prev == 'a')){
                stack.pop();
            } else {

                stack.push(ch);
            }

        }
        // System.out.println(stack);
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();

    }
}