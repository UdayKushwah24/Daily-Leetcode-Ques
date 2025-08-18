package DailyLeetcodeQuestion;

public class q12_AngleClock_1344 {
    public static double angleClock(int hour, int minutes) {
        double ans = 0.0;
        double angleInOneHour = 360 / 12;
        double totalAngleMadeByHourHand = (hour + (minutes / 60.0)) * angleInOneHour;
        double angleMadeByMinuteHand = minutes * 6;
        ans = Math.abs(totalAngleMadeByHourHand - angleMadeByMinuteHand);
        if (ans < 180) {
            return ans;
        } else {
            return 360 - ans;
        }
         
    }
}