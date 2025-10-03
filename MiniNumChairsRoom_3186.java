package InfinityChampionsProgram.Day6;

import java.util.Stack;

public class MiniNumChairsRoom_3186 {

    public static int minimumChairs(String s) {
        
        int chair = 0;
        int enter = 0;
       
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                enter++;
            } else {
                enter--;
            }
            if (enter > chair) {
                chair++;
            }
        }


        return chair;
    }
    public static void main(String[] args) {
        String s = "EEEEEEE";
        // String s = "ELELEEL";
        System.out.println(minimumChairs(s));

    }
}
