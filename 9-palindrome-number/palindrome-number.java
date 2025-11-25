class Solution {
    public boolean isPalindrome(int x) {
        String original_string = ""+x;
        String reversed_string =new  StringBuilder(original_string).reverse().toString(); 
        if(original_string.equals(reversed_string)) return true;
        else return false ;
    }
}