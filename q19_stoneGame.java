package DailyLeetcodeQuestion;

public class q19_stoneGame {
    public static void main(String[] args) {
        int n = 50;
        System.out.println(StoneGame(n));
    }

    private static boolean StoneGame(int n) {
        int sum = 0;
        int count = 0;
        int x = 10;
        while (sum <= n) {
            sum += x;
            x--;
            count++;
        }
        if (count%2 == 0 || sum == n) {
            return true;
        } else {
            return false;
        }
    }
}
