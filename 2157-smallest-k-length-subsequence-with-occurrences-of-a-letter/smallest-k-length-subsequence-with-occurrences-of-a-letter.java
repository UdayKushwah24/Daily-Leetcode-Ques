class Solution {
    public String smallestSubsequence(String s, int k, char letter, int rep) {
        int n = s.length(), cnt = 0;
        for (char c : s.toCharArray())
            if (c == letter) cnt++;

        StringBuilder st = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            while (st.length() > 0 &&
                   st.charAt(st.length() - 1) > c &&
                   st.length() - 1 + (n - i) >= k &&
                   (st.charAt(st.length() - 1) != letter || cnt > rep)) {

                if (st.charAt(st.length() - 1) == letter) rep++;
                st.deleteCharAt(st.length() - 1);
            }

            if (st.length() < k) {
                if (c == letter) {
                    st.append(c);
                    rep--;
                } else if (k - st.length() > rep) {
                    st.append(c);
                }
            }

            if (c == letter) cnt--;
        }
        return st.toString();
    }
}
