package DailyLeetcodeQuestion;

public class q17_FindChildAfterKSec_3178 {
    public int numberOfChild(int n, int time) {
        int countTime = 0;
        int pillowPerson = 0;
        boolean revDirection = false;
        while (countTime < time) {
            if (!revDirection) {
                pillowPerson++;
            } else {
                pillowPerson--;
            }
            if (pillowPerson == 0 || pillowPerson == n - 1) {
                revDirection = !revDirection;
            }
            countTime++;
        }
        return pillowPerson;
    }
}