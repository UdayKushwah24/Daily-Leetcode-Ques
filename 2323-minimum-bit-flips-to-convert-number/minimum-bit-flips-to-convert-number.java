class Solution {
    public static int minBitFlips(int start, int goal) {
        
    	return Integer.bitCount(start ^ goal);
    	
    }
}