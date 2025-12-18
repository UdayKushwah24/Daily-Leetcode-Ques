class Solution {

    public int vowel(String first) {
        int c = 0;
        for(char ch : first.toCharArray() ) {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) {
                c++;
            }
        }
        return c;
    }
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String first = arr[0];
        int vow = vowel(first);
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        for(int i = 1 ;i < arr.length; i++) {
            if(vow == vowel(arr[i])) {
                StringBuilder str = new StringBuilder(arr[i]);
                sb.append(" " + str.reverse());
            } else {
                sb.append(" " + arr[i]);
            }
        }
        return sb.toString();
    }
}