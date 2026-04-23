class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<>();
        Parenthesis(n,0,0,"",lst);
        return lst;
    }

        public static void Parenthesis(int n,int closed,int open,String str,List<String> lst) {
        if(open == n && closed == n) {
            lst.add(str);
            return;
        }
        if(open > n || closed > open) {
            return ;
        }
        Parenthesis(n, closed, open+1, str+"(",lst);
        Parenthesis(n, closed+1, open, str+")",lst);
    } 
}