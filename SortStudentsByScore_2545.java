package DailyLeetcodeQuestion;
import java.util.*;
public class SortStudentsByScore_2545 {
    public static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score,(a,b)->{
            return b[k]-a[k];
        });
        return score;
    }
}
