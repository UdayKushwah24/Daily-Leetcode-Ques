/* package DailyLeetcodeQuestion;

public class q14_Base7_504 {
    public static String convertToBase7(int num) {
        // 0 case
        if (num == 0)
            return "0";

        // negative number handle karne ke liye flag
        boolean isNegative = num < 0;
        num = Math.abs(num);

        StringBuilder sb = new StringBuilder();

        // repeatedly divide by 7
        while (num > 0) {
            sb.append(num % 7); // remainder add karo
            num /= 7; // number ko divide karo
        }

        // reverse string banao
        if (isNegative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
} */




package DailyLeetcodeQuestion;

public class q14_Base7_504 {
    public static String convertToBase7(int num) {
        // 0 case
        if (num == 0)
            return "0";

        // negative number handle karne ke liye flag
        boolean isNegative = num < 0;
        num = Math.abs(num);

        StringBuilder sb = new StringBuilder();

        // repeatedly divide by 7
        while (num > 0) {
            sb.insert(0,num % 7); // remainder add karo
            num /= 7; // number ko divide karo
        }

        // reverse string banao
        if (isNegative) {
            sb.insert(0,"-");
        }

        return sb.toString();
    }
}