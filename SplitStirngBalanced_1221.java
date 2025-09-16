package DailyLeetcodeQuestion;

 
public class SplitStirngBalanced_1221 {
    public static int balancedStringSplit(String s) {
        int ans = 0;
        int balanced = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                balanced++;
            } else {
                balanced--;
            }
            if (balanced == 0) {
                ans += 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }
}