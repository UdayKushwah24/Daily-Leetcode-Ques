// class Solution {
//     public char processStr(String s, long k) {
//         StringBuilder sb = new StringBuilder();
//         int n = s.length();

//         for (int i = 0; i < n; i++) {
//             char ch = s.charAt(i);

//             if (ch == '*') {
//                 if (sb.length() > 0) {
//                     sb.deleteCharAt(sb.length() - 1);
//                 }
//             } else if (ch == '#') {
//                 sb.append(sb.toString());
//             } else if (ch == '%') {
//                 sb.reverse();
//             } else if (ch >= 'a' && ch <= 'z') {
//                 sb.append(ch);
//             }
//         }

//         if (k >= sb.length()) {
//             return '.';
//         }

//         return sb.charAt((int) k);
//     }
// }


class Solution {
    public char processStr(String s,long k) {
        long len=0;

        for(char c:s.toCharArray()) {
            if(Character.isLowerCase(c)) {
                len++;
            } else if(c=='*') {
                if(len>0) len--;
            } else if(c=='#') {
                len*=2;
            }
        }

        if(k>=len) return '.';

        for(int i=s.length()-1;i>=0;i--) {
            char c=s.charAt(i);

            if(Character.isLowerCase(c)) {
                if(k==len-1) return c;
                len--;
            } else if(c=='*') {
                len++;
            } else if(c=='#') {
                len/=2;
                k%=len;
            } else if(c=='%') {
                k=len-1-k;
            }
        }

        return '.';
    }
}