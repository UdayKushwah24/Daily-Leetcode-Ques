class Solution {
    public boolean rotateString(String s, String goal) {
         for (int i = 0; i < s.length(); i++) {
            String start = s.substring(0, i+1);
            String end = s.substring(i+1, s.length());
            if(goal.equals((end+start))) {
                return true;
            }
        }
        return false;
    }
}