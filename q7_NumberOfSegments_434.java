package DailyLeetcodeQuestion;

public class q7_NumberOfSegments_434 {
    
/*
 * class Solution {
 * public int countSegments(String s) {
 * if(s.length() == 0) {
 * return 0;
 * }
 * 
 * String[] arr = s.split(" ");
 * 
 * return arr.length;
 * 
 * }
 * }
 */

 
    public int countSegments(String s) {
        if (s.trim().length() == 0)
            return 0; // empty or only spaces

        String[] arr = s.trim().split("\\s+"); // split by 1 or more whitespace
        return arr.length;
    }
}
