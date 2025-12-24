/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int ri = n;
        while(true) {
            int mid = l + (ri-l)/2;
            int r = guess(mid);
            if(r > 0) {
                l = mid + 1;
            } else if (r < 0) {
                ri = mid - 1;
            } else {
                return mid;
            }
        }
    }
}