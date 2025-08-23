/* package DailyLeetcodeQuestion;

 
public class PrimeArrangements_1175 {

    public static int numPrimeArrangements(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int x = n;
        int countPrime = 0;
        int nonPrime = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                countPrime++;
            }
        }
        System.out.println(countPrime);
        nonPrime = x - countPrime;
        System.out.println(nonPrime);
        int a = factorial(countPrime);
        int b = factorial(nonPrime);
        System.out.println(a+" "+ b);
        return a * b;
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int f = n * factorial(n - 1);
        return f;
    }

    private static boolean isPrime(int num) {
        int c = 0;
        for (int i = 2; i <num; i++) {
            if (num % i == 0) {
                c++;
            }
        }
        if (c >= 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // int n = 5;
        int n = 100;
        System.out.println(numPrimeArrangements(n));
    }
} */

package DailyLeetcodeQuestion;

public class PrimeArrangements_1175 {

    static int MOD = 1_000_000_007;  // _ is only used for readibilty

    public static int numPrimeArrangements(int n) {
        int countPrime = 0;

        // count primes
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                countPrime++;
            }
        }

        int nonPrime = n - countPrime;

        long a = factorial(countPrime);
        long b = factorial(nonPrime);

        return (int) ((a * b) % MOD);
    }

    private static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(numPrimeArrangements(n));
    }
}