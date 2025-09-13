// https://codeskiller.codingblocks.com/problems/281

package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class ValentineMagic {
    public static void main(String[] args) {
        // int boys[] = { 2, 11, 3 };
        // int girls[] = { 5, 7, 3, 2 };
        // Arrays.sort(boys);
        // Arrays.sort(girls);
        // System.out.println(Valentine(boys, girls, 0, 0));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] boys = new int[n];
        for (int i = 0; i < n; i++) {
            boys[i] = sc.nextInt();
        }
        int[] girls = new int[n];
        for (int i = 0; i < m; i++) {
            girls[i] = sc.nextInt();
        }
        System.out.println(Valentine(boys, girls, n, m));
    }

    private static int Valentine(int[] boys, int[] girls, int i, int j) {
        if (i == boys.length) {
            return 0;
        }
        if (j == girls.length) {
            return 99999999;
        }

        int selection = Math.abs(boys[i] - girls[j]) + Valentine(boys, girls, i + 1, j + 1);
        int rejection = Valentine(boys, girls, i, j + 1);
        return Math.min(selection, rejection);
    }
}
