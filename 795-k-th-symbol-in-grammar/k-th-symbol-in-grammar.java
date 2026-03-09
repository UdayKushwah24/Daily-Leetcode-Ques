/* class Solution {
    public int kthGrammar(int n, int k) {
        return solve(n-1, "0").charAt(k-1) - '0';
    }
    public String solve(int n, String s) {
        if(n == 0) return s;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }
       return solve(n-1 , sb.toString());
    }
} */


class Solution {
    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) % 2;
    }
   
}