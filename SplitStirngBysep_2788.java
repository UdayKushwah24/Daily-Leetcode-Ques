package DailyLeetcodeQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitStirngBysep_2788 {
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        String r = separator+"";
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String p[] = words.get(i).split("["+r+"]");
            for (int j = 0; j < p.length; j++) {
                if (p[j].length() > 0) {
                    
                    ans.add(p[j]);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("one.two.three", "four.five", "six"));
        char separator = '.';
        System.out.println(splitWordsBySeparator(words, separator));
    }
}