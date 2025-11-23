class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int p = x;
        while(p > 0) {
            sum += p%10;
            p /= 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}