class Solution {
    public int numSteps(String s) {

        int step = 0;
        while (s.length() > 1) {
            int n = s.length();
            int bit = s.charAt(n - 1) - '0';

            if (bit == 0) {
                // divide by 2
                s = s.substring(0, n - 1);
            } else {
                // add 1
                int i = n - 1;

                while (i >= 0 && s.charAt(i) == '1') {
                    i--;
                }

                if (i < 0) {
                    // all 1s case
                    s = "1" + "0".repeat(n);
                } else {
                    // flip first 0 to 1, rest to 0
                    s = s.substring(0, i) + "1" + "0".repeat(n - i - 1);
                }
            }
            step++;
        }
        return step;
    }
}
