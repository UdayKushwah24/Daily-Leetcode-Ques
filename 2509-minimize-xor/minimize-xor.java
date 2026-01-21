 

class Solution {
    public int minimizeXor(int num1, int num2) {
         int x = 0;

        int set = 0;
        while (num2 > 0) {
            set++;
            num2 = (num2 & (num2 - 1));
        }

        for (int i = 30; i >= 0; i--) {
            int mask = 1 << i;
            if ((num1 & mask) > 0) {
                x = (x | mask);
                set--;
                if(set == 0) {
                    return x;
                }
            }
        }
        for (int i = 0; i <= 30; i++) {
             int mask = 1 << i;
            if ((num1 & mask) == 0) {
                x = (x | mask);
                set--;
                if(set == 0) {
                    return x;
                }
            }
        }

        

        return x;
    }
}