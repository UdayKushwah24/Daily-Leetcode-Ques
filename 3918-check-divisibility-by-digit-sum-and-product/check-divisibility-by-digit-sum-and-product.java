class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
        int mul = 1;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            mul *= rem;
            num /= 10;
        }
        int totalSum = sum + mul;

        if (n % totalSum == 0) {
            return true;
        } else {
            return false;
        }

    }
}