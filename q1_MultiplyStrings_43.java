package DailyLeetcodeQuestion;

public class q1_MultiplyStrings_43 {
    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] pro = new int[n + m];
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';

                int mul = digit1 * digit2;
                int sum = pro[i + j + 1] + mul;

                pro[i + j + 1] = sum % 10;
                pro[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pro.length; i++) {
            if (sb.length() == 0 && pro[i] == 0) {
                continue;
            }
            sb.append(pro[i]);
        }
        return sb.toString();
    }
}
