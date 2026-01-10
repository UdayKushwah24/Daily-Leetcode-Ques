class Solution {
      List<String> ans = new ArrayList<>();
 

    public   List<String> letterCasePermutation(String s) {
        solve(s, 0, "");
        return ans;
    }

    private   void solve(String s, int i, String cc) {

        if(i == s.length()) {
            ans.add(cc);
            return;
        }

        if(s.charAt(i)-'0' >= 0 && s.charAt(i)-'0'<=9) {
            solve(s, i+1, cc+s.charAt(i));
        } else {
            solve(s, i+1, cc+s.charAt(i));
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                solve(s, i+1, cc+ (char)((int)s.charAt(i)-32));
            } else {
                solve(s, i+1, cc+ (char)((int)s.charAt(i)+32));
            }
        }
    }
}