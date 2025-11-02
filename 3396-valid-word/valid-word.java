class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        boolean isalphabet = false;
        
        boolean iscon = false;
        for(int i = 0;  i < word.length();i++) {
            int ch = word.charAt(i);
            if(ch == 97 || ch == 101 || ch == 105 || ch == 111 || ch == 117 || ch == 65 || ch == 69 || ch == 73 || ch == 79 || ch == 85){
                isalphabet = true;
            }
            
            else if((ch >= 48 && ch <= 57)) continue;
            
            else if((ch >= 97 && ch <= 122) ||( ch >= 65 && ch <= 90))
            {   iscon = true;
                 continue; }
            else return false;


        }

        return isalphabet && iscon;

    }
}