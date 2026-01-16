class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int m = word1.length();
        int n = word2.length();
        while (i < m && j < n) {
            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                char ch1 = word1.charAt(i);
                sb.append(ch1);
                i++;
            } else {
                char ch2 = word2.charAt(j);
                sb.append(ch2);
                j++;
            }
        }
        if (i < m) {
            sb.append(word1.substring(i));
        }
        if (j < n) {
            sb.append(word2.substring(j));
        }

        return sb.toString();

    }
}