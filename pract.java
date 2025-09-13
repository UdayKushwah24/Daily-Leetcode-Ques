package DynamicProgramming;

import java.util.*;

public class pract {

    public static void main(String[] args) {
        int[] coin = {1, 2, 5};
        int amount = 5;
        System.out.println(coinChange(coin, amount, 0));
    }

    private static int coinChange(int coin[], int amount, int i ) {
        if (i >= coin.length) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }
        int inc = 0, exc = 0;
        if (amount >= coin[i]) {
            inc = coinChange(coin, amount - coin[i], i);
        }
        exc = coinChange(coin, amount, i + 1);
        return  (inc + exc);
    }
}
 