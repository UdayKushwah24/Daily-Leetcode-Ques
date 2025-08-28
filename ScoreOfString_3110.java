package DailyLeetcodeQuestion;

public class ScoreOfString_3110 {
    public static int scoreOfString(String s) {
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(scoreOfString(s));
    }
}