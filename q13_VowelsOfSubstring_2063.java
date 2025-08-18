package DailyLeetcodeQuestion;

public class q13_VowelsOfSubstring_2063 {
    public static long countVowels(String word) {
        long count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                long l = word.length() - i;
                count += (l * i) + l;
            }
        }
        return count;
    }
}