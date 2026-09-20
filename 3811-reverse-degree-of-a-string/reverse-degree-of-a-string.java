class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx =   'z' - s.charAt(i) +1 ;
            // System.out.println(idx);
            sum += idx * (i + 1);
        }
        return sum;
    }
}