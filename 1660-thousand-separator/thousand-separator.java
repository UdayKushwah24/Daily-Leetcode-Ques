class Solution {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        String s = n + "";
        int c = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            c++;
            sb.insert(0, s.charAt(i));

            if(c == 3 && i != 0) {    
                sb.insert(0, ".");
                c = 0;
            }
        }
        return sb.toString();
    }
}
