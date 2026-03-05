/* class Solution {



    int count = 0;

    public void Partition(String ques) {
        if (ques.length() == 0) {
            // System.out.println(ans);
            count++;
            return;
        }
        for (int i = 1; i <= ques.length(); i++) {
            String s = ques.substring(0, i);
            if (s.length() <= 2 && Integer.valueOf(s) <= 26 && s.charAt(0) != '0') {
                Partition(ques.substring(i));
            }
        }
    }

    public int numDecodings(String s) {
        count = 0;
        Partition(s);
        return count;

    }
}
  */

import java.util.*;

class Solution {
    HashMap<String, Integer> dp = new HashMap<>();
    public int Partition(String ques) {
        if (ques.length() == 0) {
            return 1;
        }
        if (dp.containsKey(ques)) {
            return dp.get(ques);
        }
        int count = 0;
        for (int i = 1; i <= ques.length(); i++) {
            String s = ques.substring(0, i);
            if (s.length() <= 2 && Integer.valueOf(s) <= 26 && s.charAt(0) != '0') {
                count += Partition(ques.substring(i));
            }
        }
        dp.put(ques, count);
        return count;
    }

    public int numDecodings(String s) {
        dp.clear();
        return Partition(s);
    }
}