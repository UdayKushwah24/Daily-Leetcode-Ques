class MagicDictionary {

    String[] dict;

    public MagicDictionary() {
    }

    public void buildDict(String[] dictionary) {
        dict = dictionary;
    }

    public boolean search(String searchWord) {

        for (String word : dict) {

            // length same honi chahiye
            if (word.length() != searchWord.length()) continue;

            int diff = 0;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diff++;
                }
                if (diff > 1) break;
            }

            // exactly 1 character difference
            if (diff == 1) return true;
        }

        return false;
    }
}
