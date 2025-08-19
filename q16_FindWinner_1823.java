package DailyLeetcodeQuestion;

import java.util.ArrayList;

public class q16_FindWinner_1823 {
    // TC : o(n) + O(n^2)
    // SC : o(n)  
    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        // O(n)
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        // n^2
        while (list.size() > 1) {
            index = (index + (k-1)) % list.size();
            list.remove(index);
        }
        return list.get(0);

    }
    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(findTheWinner(n, k));
    }
}