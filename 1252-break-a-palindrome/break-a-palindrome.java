/* class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1)
            return "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        sb.append(palindrome.charAt(0));
        for (int i = 1; i < n/2; i++) {
            if (palindrome.charAt(i - 1) <= palindrome.charAt(i)) {
                sb.append('a');
                idx = i+1;
                break;
            } 
                sb.append(palindrome.charAt(i));
            
        }
        for (int j = idx ; j < n; j++) {
            sb.append(palindrome.charAt(j));
        }
        return sb.toString();
    }
} */
class Solution {
    public String breakPalindrome(String palindrome) {

        int n = palindrome.length();
        if (n == 1) return "";

        char[] arr = palindrome.toCharArray();

        for (int i = 0; i < n/2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }

        arr[n-1] = 'b';
        return new String(arr);
    }
}