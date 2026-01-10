class Solution {
    public void Permutation(List<String> ll, String str, String ans) {
        if (str.length() == 0) {
            ll.add(ans);
            return;
        }

        char ch = str.charAt(0);

        Permutation(ll, str.substring(1), ans + ch);
        if (ch >= 'A' && ch <= 'Z') {
            char next = (char) (ch + 32);
            Permutation(ll, str.substring(1), ans + next);
        } else if ((ch >= 'a' && ch <= 'z')) {
            char next = (char) (ch - 32);
            Permutation(ll, str.substring(1), ans + next);
        }

    }

    public List<String> letterCasePermutation(String s) {
        List<String> ll = new ArrayList<>();
        Permutation(ll, s, "");
        return ll;
    }
}