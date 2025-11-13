class Solution {
    public int strStr(String haystack, String needle) {
        int i = -1;
        if(haystack.contains(needle) ) {
            i = haystack.indexOf(needle);
            
        }
        return i;
    }
}