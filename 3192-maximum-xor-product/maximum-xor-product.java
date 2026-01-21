class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        
      long mod = 1000000007;
        long axorx = 0;
        long bxorx = 0;
        long setBit = 1;
        for (int i = 49; i >= n; i--) {
            if ((1 & (a >> i)) == 1) {
                axorx = (axorx | (setBit << i)) ;
            }
            if ((1 & (b >> i)) == 1) {
                bxorx = (bxorx | (setBit << i)) ;
            }
        }
        for (
            int i = n - 1; i >= 0; i--) {
            int abit = (int) (1 & (a >> i));
            int bbit = (int) (1 & (b >> i));
            if (abit == bbit) {
                axorx = (axorx | (setBit << i)) ;
                bxorx = (bxorx | (setBit << i)) ;
            } else {
                if (axorx < bxorx) {
                    axorx = (axorx | (setBit << i));   
                } else {
                    bxorx = (bxorx | (setBit << i)) ;

                }
            }
        }
        // System.out.println(axorx + " " + bxorx);
        // System.out.println(axorx*bxorx);
        // System.out.println();
        return (int) (((axorx % mod)*(bxorx% mod)) % mod);}
}


/* 


public static int maximumXorProduct(long a, long b, int n) {
        long mod = 1000000007;
        long axorx = 0;
        long bxorx = 0;
        long setBit = 1;
        for (int i = 49; i >= n; i--) {
            if ((1 & (a >> i)) == 1) {
                axorx = (axorx ^ (setBit << i)) ;
            }
            if ((1 & (b >> i)) == 1) {
                bxorx = (bxorx ^ (setBit << i)) ;
            }
        }
        for (
            int i = n - 1; i >= 0; i--) {
            int abit = (int) (1 & (a >> i));
            int bbit = (int) (1 & (b >> i));
            if (abit == bbit) {
                axorx = (axorx ^ (setBit << i)) ;
                bxorx = (bxorx ^ (setBit << i)) ;
            } else {
                if (axorx < bxorx) {
                    axorx = (axorx ^ (setBit << i));
                } else {
                    bxorx = (bxorx ^ (setBit << i)) ;

                }
            }
        }
        // System.out.println(axorx + " " + bxorx);
        // System.out.println(axorx*bxorx);
        // System.out.println();
        return (int) (((axorx % mod)*(bxorx% mod)) % mod);
    } */