class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

      long n = num; 
     if (n < 0) n = (long)num + (1L << 32);   // convert negative to unsigned value

        String h = "0123456789abcdef";
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = (int)(n % 16);    // remainder
            sb.append(h.charAt(r));
            n /= 16;                  // divide
        }
        return sb.reverse().toString();
    }
}
