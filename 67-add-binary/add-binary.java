class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (m >= 0 && n >= 0) {
            int abit = a.charAt(m) - '0';
            int bbit = b.charAt(n) - '0';
            int sum = abit + bbit + c;

            sb.insert(0, sum % 2);
            c = sum / 2;
            m--;
            n--;
        }
        
        while (m >= 0) {
            int abit = a.charAt(m) - '0';

            int sum = abit + c;

            sb.insert(0, sum % 2);
            c = sum / 2;
            m--;

        }

        while (n >= 0) {
            int bbit = b.charAt(n) - '0';

            int sum = bbit + c;

            sb.insert(0, sum % 2);
            c = sum / 2;
            n--;

        }
        if(  c == 1) {

            sb.insert(0, 1);
        }
        return sb.toString();

    }
}