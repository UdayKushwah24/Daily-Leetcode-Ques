package DailyLeetcodeQuestion;

public class q15_PassPillow_2582 {
    public int passThePillow(int n, int time) {
        int countTime = 0;
        int pillowPerson = 1;
        boolean revDirection = false;
        while (countTime < time) {
            if (!revDirection) {
                pillowPerson++;
            } else {
                pillowPerson--;
            }
            if (pillowPerson == 1 || pillowPerson == n) {
                revDirection = !revDirection;
            }
            countTime++;
        }
        return pillowPerson;
    }
}