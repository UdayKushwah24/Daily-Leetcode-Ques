/* class Solution {
    public int minOperations(String s) {
        int bit = 0;
        int a = operation(s, '0');
        int b = operation(s, '1');
        return Math.min(a, b);
    }

    public static int operation(String s, char ch) {
        int bit = 0;
        int n = s.length();
        int idx = 0;
        for (int i = 0; i <= n / 2; i++) {
            if (idx < n && s.charAt(idx) != ch) {
                bit++; 
            }
            idx += 2;
        }
        ch = ch == '1' ? '0' : '1';
        idx = 1;
        for (int i = 0; i <= n / 2; i++) {
            if (idx < n && s.charAt(idx) != ch) {
                bit++;
            }
            idx += 2;
        }
        return bit;
    }
} */

class Solution {
    public int minOperations(String s) {
        int bit = 0;
        int a = operation(s, '0');
        int b = operation(s, '1');
        return Math.min(a, b);
    }

    public static int operation(String s, char ch) {
        int bit = 0;
        int n = s.length();
        int idx = 0;
        int idx1 = 1;
        char ch2 = ch == '1' ? '0' : '1';
        for (int i = 0; i <= n / 2; i++) {
            if (idx < n && s.charAt(idx) != ch) {
                bit++;
            }
            if (idx1 < n && s.charAt(idx1) != ch2) {
                bit++;
            }
            idx1 += 2;
            idx += 2;
        }

        return bit;
    }
}