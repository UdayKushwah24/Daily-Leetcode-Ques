package InfinityChampionsProgram.Day1;

import java.util.ArrayList;

 
public class CanPlaceFlowers_605 {
   
   /*  public static boolean canPlaceFlowers(int[] arr, int x) {
    int need = 0;
    for (int i = 0; i < arr.length;) {
        int c = 0;
        while (i < arr.length && arr[i] == 0) {
            c++;
            i++;
        }
        if (c % 2 == 0) {
            need += (c-1 / 2)-1 ;
        } else {
            need += (c+1) / 2;
        }
        i++;
   
    }
    System.out.println(need);
    if (need <= x) {
        return false;
    } else {
        return true;
    }
   } */
   
   public static void main(String[] args) {
       int[] flowerbed = { 1, 0, 0, 0, 0, 1, 0, 0,0, 1, 0, 1, 0, 0, 0 };
       int n = 3;
       System.out.println(canPlaceFlowers(flowerbed, n));
   }

    public static boolean canPlaceFlowers(int[] arr, int x) {
        ArrayList<Integer> ll = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int c = 1;
            while (i < arr.length && arr[i - 1] == 0 && arr[i] == 0) {
                c++;
                i++;
            }
            if (c != 1) {
                
                ll.add(c);
            }
        }
        System.out.println(ll);
        int needFlower = 0;
        for (int i = 0; i < ll.size(); i++) {
            int zero = ll.get(i);
            if (zero % 2 == 0) {
                needFlower += (zero - 1) / 2;
            } else {
                needFlower += zero / 2;

            }
        }
        if (needFlower >= x) {
            return true;
        }
        

        return false;
    }
   

}
