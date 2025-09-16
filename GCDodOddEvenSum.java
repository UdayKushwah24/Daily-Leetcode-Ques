package DailyLeetcodeQuestion;

 
public class GCDodOddEvenSum {
    public static int gcdOfOddEvenSums(int n) {
        int evensum = 0;
        int oddsum = 0;
        String s = "" + n;
        int k = 2;
        int j = 1;
        while (n-->0) {
            evensum += k;
            oddsum += j;
            k += 2;
            j += 2;
        }

        // System.out.println(evensum+" "+oddsum);
        int gcd = 1;
        for (int i = 1; i <= Math.min(oddsum, evensum); i++) {
            if (oddsum % i == 0 && evensum % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    public static void main(String[] args) {
        int  n = 10;
        System.out.println(gcdOfOddEvenSums(n));
    }
}