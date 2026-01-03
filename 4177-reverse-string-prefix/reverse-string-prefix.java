class Solution {
    public String reversePrefix(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(i < k) {
                sb.insert(0, s.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}