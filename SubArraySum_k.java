package Map;

import java.util.HashMap;

public class SubArraySum_k {
    public static void main(String[] args) {
         int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
             
        }
        System.out.println(ans);
    }
}
