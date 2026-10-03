// class Solution {
//     public int longestValidParentheses(String s) {
        
//         int max = 0;
//         for (int i = 0; i < s.length(); i++) {
//             for (int j = i + 1; j <s.length(); j++) {
//                 String str = s.substring(i, j + 1);
//                 if (LongestParenthesis(str)) {
//                     max = Math.max(max,j-i+1);
//                 }
//             }
//         }
//         return max;
//     }

//     public boolean LongestParenthesis(String s) {
//         int n = s.length();
//         while (s.length() > 0) {
//             if (s.contains("()")) {
//                 s = s.replace("()", "");
//             } else if (s.contains("[]")) {
//                 s = s.replace("[]", "");
//             } else if (s.contains("{}")) {
//                 s = s.replace("{}", "");
//             } else {
//                 break;
//             }
//         }

//         return s.length() == 0;

//     }
// }


class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }
}