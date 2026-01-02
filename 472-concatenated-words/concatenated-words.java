class Solution {
    public boolean concatable(String s, Set<String> set, Map<String, Boolean> memo) {
        if (memo.containsKey(s) && !memo.get(s))
            return false;
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (set.contains(prefix) && (set.contains(suffix) || concatable(suffix, set, memo))) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Map<String, Boolean> memo = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String s : words) {
            if (concatable(s, set, memo))
                res.add(s);
        }
        return res;
    }
}

/* 
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> s = new HashSet<>();
        List<String> concatenateWords = new ArrayList<>();
        for(String word : words)
            s.add(word);
        for(String word : words) {
            if(checkConcatenate(word, s) == true)
                concatenateWords.add(word);
        }
        return concatenateWords;
    }
    public boolean checkConcatenate(String word, Set<String> s) {
        for(int i = 1; i < word.length(); i++) {
            String prefixWord = word.substring(0, i);
            String suffixWord = word.substring(i, word.length());
            if(s.contains(prefixWord) && (s.contains(suffixWord) || checkConcatenate(suffixWord, s)))
                return true;
        }
        return false;
    }
}

 */