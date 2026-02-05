class Solution {
   public   String replaceWords(List<String> dictionary, String sentence) {
        String arr[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < dictionary.size(); i++) {
            set.add(dictionary.get(i));
        }

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            sb.append(findRoot(word, set) + " ");
        }
        return sb.toString().trim();
    }

    private   String findRoot(String word, HashSet<String> set) {
        for (int i = 1; i < word.length(); i++) {
            String s = word.substring(0, i);
            if (set.contains(s)) {
                return s;
            }
        }
        return word;
    }
}