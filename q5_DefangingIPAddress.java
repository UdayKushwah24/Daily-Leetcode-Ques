package DailyLeetcodeQuestion;

public class q5_DefangingIPAddress {
    public static String defangIPaddr(String address) {
        String[] arr = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sb.append("[.]");
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }
}
