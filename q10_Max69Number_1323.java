package DailyLeetcodeQuestion;

public class q10_Max69Number_1323 {
    public static int maximum69Number(int num) {
        String ques = num + "";
        StringBuilder sb = new StringBuilder();
        int idx = -1;
        for (int i = 0; i < ques.length(); i++) {
            if (ques.charAt(i) == '6') {
                sb.append('9');
                idx = i;
                break;
            } else {
                sb.append(ques.charAt(i));
            }
        }
        String ans = "";

        System.out.println(sb.toString());
        System.out.println();
        if (idx != -1) {
            String str = ques.substring(idx + 1);
            ans += sb.toString() + str;
        }
        if (ans.length() == 0) {
            return num;
        } else {

            return Integer.parseInt(ans);
        }
    }
    public static void main(String[] args) {
        int num = 9999;
        System.out.println(maximum69Number(num));
    }
}