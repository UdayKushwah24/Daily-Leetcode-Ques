import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int minFinishTime = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for (int i = 0; i < n; ++i) {
            int landStart = landStartTime[i];
            int landDur = landDuration[i];

            for (int j = 0; j < m; ++j) {
                int waterStart = waterStartTime[j];
                int waterDur = waterDuration[j];

                // Plan A: Do land task first, then water
                int landEnd = landStart + landDur;
                int waterBegin = Math.max(landEnd, waterStart);
                int totalTime1 = waterBegin + waterDur;

                // Plan B: Do water task first, then land
                int waterEnd = waterStart + waterDur;
                int landBegin = Math.max(waterEnd, landStart);
                int totalTime2 = landBegin + landDur;

                // Take the minimum finish time of both plans
                minFinishTime = Math.min(minFinishTime, Math.min(totalTime1, totalTime2));
            }
        }

        return minFinishTime;
    }
}
