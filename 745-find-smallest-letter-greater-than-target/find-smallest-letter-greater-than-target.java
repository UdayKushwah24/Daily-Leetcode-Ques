class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length;
        char ans = ' ';
        if(target >= letters[letters.length-1]) {
            return letters[0];
        }
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if(letters[mid] > target){
                ans = letters[mid];
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        // if(ans != ' ') {
        //     return ans;
        // } else {
        //     return letters[0];
        // }
        return ans;
    }
}