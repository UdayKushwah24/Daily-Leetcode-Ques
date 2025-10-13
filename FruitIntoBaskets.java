package InfinityChampionsProgram.Day1;

import java.util.ArrayList;
import java.util.HashMap;

public class FruitIntoBaskets {
    /*
     * public static void main(String[] args) {
     * int[] basket = { 1, 1, 2, 3, 3, 3, 3, 4, 5, 6, 6, 6, 6, 6 };
     * ArrayList<int[]> ll = new ArrayList<>();
     * for (int i = 1; i < basket.length; i++) {
     * int c = 1;
     * while (i < basket.length && basket[i - 1] == basket[i]) {
     * c++;
     * i++;
     * }
     * ll.add(new int[] { basket[i - 1], c });
     * }
     * // for (int i = 0; i < ll.size(); i++) {
     * // System.out.println(ll.get(i)[0]+" -> "+ll.get(i)[1]);
     * // }
     * for (int i = 1; i < ll.size(); i++) {
     * 
     * }
     * }
     */

    public static void main(String[] args) {
        int[] basket = { 1, 1, 2, 3, 3, 3, 3, 4, 5, 6, 6, 6, 6, 6 };
        System.out.println(Basket(basket));
    }

    private static int Basket(int[] basket) {
        int n = basket.length;
        int maxLen = 0;
        int l = 0, r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            if (!map.containsKey(basket[r])) {
                map.put(basket[r], 1);
            } else {
                map.put(basket[r], map.get(basket[r]) + 1);
            }

            while (map.size() > 2) {
                map.put(basket[l], map.get(basket[l]) - 1);
                if (map.get(basket[l]) == 0) {
                    map.remove(basket[l]);
                }
                l++;
                
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
