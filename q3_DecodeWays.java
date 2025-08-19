package DailyLeetcodeQuestion;

public class q3_DecodeWays {

    public static void main(String[] args) {
        // String num = "06";
        String num = "11111111";
        // String num = "3333";
        // String num = "11106";
        // System.out.println(CountWays(num));
        Partition(num, "");
        System.out.println(count);
    }

 
    static int count = 0;

    public static void Partition(String ques, String ans) {
        if (ques.length() == 0) {
            // System.out.println(ans);
            count++;
            return;
        }
        for (int i = 1; i <= ques.length(); i++) {
            String s = ques.substring(0, i);
            if (s.length() <= 2 && Integer.valueOf(s) <= 26 && s.charAt(0) != '0') {
                Partition(ques.substring(i), ans + s + "|");
            }
        }
    }
}
