package DailyLeetcodeQuestion;

public class LargestNum_2264 {
    public static String largestGoodInteger(String num) {
        String arr[] = num.split("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.err.println();
        int ans = -1 ;
        for (int i = 0; i < arr.length-2 ; i++) {
           
            if (arr[i].equals(arr[i + 1]) && arr[i + 1].equals(arr[i + 2])) {
                
                ans = Math.max(ans, Integer.parseInt(arr[i]));

            }
           
        }
        System.out.println(ans);
        if (ans == -1) {
            return "";
        }

        String q = ans + "";
        return q.repeat(3);
    }
    public static void main(String[] args) {
        String num = "67771999";
        System.out.println(largestGoodInteger(num));
    }
}
