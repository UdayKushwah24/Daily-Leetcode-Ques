package DailyLeetcodeQuestion;

public class q11_ReverseDegree_3498 {
    public static int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx =   'z' - s.charAt(i) +1 ;
            System.out.println(idx);
            sum += idx * (i + 1);
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(reverseDegree(s));
    }
}