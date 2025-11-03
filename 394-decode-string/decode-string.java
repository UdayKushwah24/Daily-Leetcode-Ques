class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String temp = "";
                while (!stack.peek().equals("[")) {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                String numString = "";
                while (!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    numString = stack.pop() + numString;
                }
                int num = Integer.parseInt(numString);
                // String repeat = temp.repeat(num);
                StringBuilder repeat = new StringBuilder();
                for(int p = 0; p < num; p++) {
                    repeat.append(temp);
                }
                stack.add(repeat.toString());
            } else {
                stack.push(s.charAt(i) + "");
            }
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}