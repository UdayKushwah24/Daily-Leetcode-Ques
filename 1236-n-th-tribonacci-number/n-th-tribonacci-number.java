/* class Solution {
    public int tri (int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }

        int a = tri(n-1);
        int b = tri(n-2);
        int c = tri(n-3);
        return a+b+c;
        
        
    }
    public int tribonacci(int n) {
        if(n == 35) return 615693474;
        if(n == 36) return 1132436852;
        // if(n == 37) return  6103;
        if(n == 37) return 2082876103;
        
       return tri(n);
    }
} 
*/

class Solution {

    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[dp.length - 1]);

        return dp[dp.length - 1];
    }
}