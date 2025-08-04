package DailyLeetcodeQuestion;

public class q2_ApplyDiscountPrice_2288 {
/* 
public static void main(String[] args) {
String sentence = "there are $1 $2 and 5$ candies in the shop";
double discount = 50.0 / 100;
// String sentence = "1 $6666666662 $3 $ 4 $5 $6 7 8$ $9 $10$";
// double discount = 100 / 100.0;
String[] arr = sentence.split(" ");
String ans = "";
for (int i = 0; i < arr.length; i++) {
    if (arr[i].charAt(0) == '$') {
        boolean isprice = CheckPrice(arr[i].substring(1));
        if (isprice) {
            String price = arr[i].substring(1);
            int p = Integer.valueOf(price);
            System.out.println(p);
            double a = (double) (p * (1- discount));
            String result = String.format("%.2f", a);
            ans += "$" +  result + " ";
        } else {
            ans += arr[i] + " ";
        }
    } else {
        ans += arr[i] + " ";
    }

}
System.out.println(ans.trim());
// System.out.println(ans.substring(0, ans.length() - 1)+".");

}

private static boolean CheckPrice(String string) {
if (string.length() == 0) {
    return false;
}
for (int i = 0; i < string.length(); i++) {
    char ch = string.charAt(i);
    if (!(ch >= '0' && ch <= '9')) {
        return false;
    }
}
return true;
} */
   
public static void main(String[] args) {
    String sentence = "there are $300 $2 and 5$ candies in the shop";
    int discount = 18;
    // String sentence = "1 $6666666662 $3 $ 4 $5 $6 7 8$ $9 $10$";
    // double discount = 100 / 100.0;
    String[] arr = sentence.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
        if (arr[i].charAt(0) == '$') {
            boolean isprice = CheckPrice(arr[i].substring(1));
            if (isprice) {
                String price = arr[i].substring(1);
                long originalPrice = Long.valueOf(price);
                double priceAfterDiscount = originalPrice - (discount * originalPrice) / 100.0;
                // System.out.println(p);
                String result = String.format("%.2f", priceAfterDiscount);
                sb.append("$"+ result + " ");
            } else {
                sb.append(arr[i] + " ");
                
            }
        } else {
            sb.append(arr[i] + " ");
             
        }

    }
    System.out.println(sb.toString().trim());

}

private static boolean CheckPrice(String string) {
    if (string.length() == 0) {
        return false;
    }
    for (int i = 0; i < string.length(); i++) {
        char ch = string.charAt(i);
        if (!(ch >= '0' && ch <= '9')) {
            return false;
        }
    }
    return true;
}
}



/*
 * package DailyLeetcodeQuestion;
 * 
 * public class q2_ApplyDiscountPrice_2288 {
 * 
 * public static void main(String[] args) {
 * String sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
 * double discount = 100 / 100.0;
 * 
 * String[] arr = sentence.split(" ");
 * StringBuilder ans = new StringBuilder();
 * 
 * for (String word : arr) {
 * if (word.startsWith("$") && isValidPrice(word.substring(1))) {
 * // Convert to int and apply discount
 * int price = Integer.parseInt(word.substring(1));
 * double discounted = price * (1 - discount);
 * // Format to 2 decimal places
 * String formatted = String.format("$%.2f", price * (1 - discount) + price);
 * ans.append(formatted).append(" ");
 * } else {
 * ans.append(word).append(" ");
 * }
 * }
 * 
 * // Remove trailing space
 * System.out.println(ans.toString().trim());
 * }
 * 
 * // Helper method to check if price is valid (only digits)
 * private static boolean isValidPrice(String str) {
 * for (char ch : str.toCharArray()) {
 * if (!Character.isDigit(ch)) return false;
 * }
 * return str.length() > 0;
 * }
 * }
 * 
 */