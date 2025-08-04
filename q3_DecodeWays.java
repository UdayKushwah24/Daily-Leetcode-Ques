package DailyLeetcodeQuestion;

public class q3_DecodeWays {
    public static void main(String[] args) {
        String num = "11106";
        System.out.println(CountWays(num));
    }

    private static int CountWays(String num) {
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            for (int j = i+1; j < num.length(); j++) {
                String s = num.substring(i, j);
                if (s.charAt(0) != '0') {
                    int n = Integer.valueOf(i);
                    
                }
            }
        }
    }
}
