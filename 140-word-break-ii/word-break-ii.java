class Solution {
   
    List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        String currSentence = "";
        solve(0,currSentence, s, wordDict);
        return result;

    }

    public void solve(int i , String curr, String s,List<String> wordDict ) {
        if (i >= s.length()) {
            result.add(curr.trim());
            return;
        }

        for(int j = i ; j < s.length(); j++){
            String word = s.substring(i, j+1);
            if(wordDict.contains(word)) {
                solve(j+1, curr+word+" ", s, wordDict);
            }
        }
    }

 
}