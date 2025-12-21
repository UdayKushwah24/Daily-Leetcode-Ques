// class Solution {
//     public int generateKey(int num1, int num2, int num3) {
//         return Math.min(num1/1000, Math.min(num2/1000, num3/1000)) * 1000 + Math.min(num1/100 % 10, Math.min(num2/100 % 10, num3/100 % 10)) * 100 + Math.min(num1/10 % 10, Math.min(num2/10 % 10, num3/10 % 10)) * 10 + Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10)); 
//     }
// }




class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0, x = 1;
        while(num1 > 0 || num2 > 0 || num3 > 0) {
            int min_digit = Math.min((num1 % 10) , (num2 % 10));
            min_digit = Math.min((num3 % 10) , min_digit);
            ans += x * min_digit;
            x *= 10;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return ans;
    }
}