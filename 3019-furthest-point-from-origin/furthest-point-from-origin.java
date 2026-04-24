class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countR = 0;
        int countL  = 0;
        int countSpace = 0;
        for(int i = 0; i < moves.length() ; i++) {
            if(moves.charAt(i )== 'R' ){
                countR++;
            } else if (moves.charAt(i )== 'L' ){
                countL++;
            } else {
                countSpace++;
            }
        }

        return countSpace +  Math.max(countR, countL) - Math.min(countR, countL);
    }
}