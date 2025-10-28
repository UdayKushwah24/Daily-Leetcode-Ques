package DynamicProgramming;

public class DeleteOperationString_583 {
    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        int f = minDistance(word1, word2, 0, 0);
        int s = minDistance(word2, word1, 0, 0);
        System.out.println(Math.min(f, s));
    }
    
    public static int minDistance(String word1, String word2, int i, int j) {
        
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (j >= word2.length()) {
            return word1.length() - i;
        }

        int ans = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = minDistance(word1, word2, i + 1, j + 1);
        } else {
            int d = minDistance(word1, word2, i + 1, j);
            ans = d + 1;
        }
        return ans;
    }
}
