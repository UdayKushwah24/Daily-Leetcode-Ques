class Solution {
   
    List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        String currSentence = "";
        solve(0,currSentence, s, wordDict);
        return result;

    }

    public void solve(int i, String currSentence, String s,  List<String> wordDict ) {

        if(i >= s.length()){
            result.add(currSentence.trim());
            
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String part = s.substring(i, j+1);
            if(wordDict.contains(part)) {
                solve(j+1, currSentence+" "+part, s, wordDict);
            }
        }
    }
}