/* 
public class Solution {
    public int removeAlmostEqualCharacters(String s) {
        int ans = 0;
        int n = s.length();
        int i = 1;
        while (i < n) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) == 1 || s.charAt(i) == s.charAt(i - 1)) {
                ans++;
                i = i + 2;
                continue;
            }
            i++;
        }
        return ans;
    }
} */


class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int cnt = 0;

        for (int i = 1; i < word.length();) {
            char prev = word.charAt(i-1);
            char curr = word.charAt(i);
            if (Math.abs(curr - prev) <= 1) {
                cnt++;
                i++;
            }
            i++;
        }
        return cnt;
    }
}