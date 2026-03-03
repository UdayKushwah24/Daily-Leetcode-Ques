class Solution {
    public char findKthBit(int n, int k) {
        return FindBit("0",k).charAt(k-1);
    }    
    public static String reverse_invert(String str) {

        //invert the digits 
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                ans.append('1'); 
            } else {
                ans.append('0'); 

            }
        }
        //reverse the invert of digits
        StringBuilder answer = new StringBuilder();
        for (int i = str.length()-1; i >=0; i--) {
            answer.append(ans.charAt(i));
        }
        return answer.toString();
    }

    public static String FindBit(String previous,int k) {
        if(previous.length()> k) {
            return previous;
        }
        return FindBit(previous+'1'+reverse_invert(previous), k);
    }
} 
  