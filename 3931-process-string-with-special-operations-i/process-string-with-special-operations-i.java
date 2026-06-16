class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(sb.length() > 0 && ch == '*') {
                sb.deleteCharAt(sb.length()-1);
            } else if(ch == '#') {
                sb.append(sb.toString());
            } else if(ch == '%') {
                sb.reverse();
            }  else if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

// class Solution {
//     public String processStr(String s) {
//         StringBuilder ans = new StringBuilder();

//         for (char ch : s.toCharArray()) {
//             if (Character.isLowerCase(ch)) {
//                 ans.append(ch);
//             }
//             else if (ch == '*') {
//                 if (ans.length() > 0) {
//                     ans.deleteCharAt(ans.length() - 1);
//                 }
//             }
//             else if (ch == '#') {
//                 ans.append(ans.toString());
//             }
//             else {
//                 ans.reverse();
//             }
//         }

//         return ans.toString();
//     }
// }