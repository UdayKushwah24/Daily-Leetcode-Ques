class Solution {
    public boolean makeEqual(String[] words) {

        int n = words.length;
        int[] arr = new int[26];

        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }
        }

        for (int e : arr) {
            if (e % n != 0) {
                return false;
            }
        }

        return true;
    }
}