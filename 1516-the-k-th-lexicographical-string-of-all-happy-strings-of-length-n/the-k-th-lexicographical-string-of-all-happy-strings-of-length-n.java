class Solution {
    String str = "abc";
    public String getHappyString(int n, int k) {
        List<String> ll = new ArrayList<>();
        solve(n, "", ll);
        Collections.sort(ll);
        return ll.size() >= k ? ll.get(k-1) : "";
    }

    public void solve(int n, String ans, List<String> ll) {
        if(n == ans.length()) {
            ll.add(ans);
            return;
        }
        for(int i = 0; i < 3 ; i++) {
            if(ans.length() == 0 || ans.charAt(ans.length()-1) != str.charAt(i)) {
                solve(n, ans + str.charAt(i), ll);
            }
        }
    }
}