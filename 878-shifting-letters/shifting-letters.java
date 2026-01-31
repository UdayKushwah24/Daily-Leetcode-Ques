/* class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long cumSum = Arrays.stream(shifts).sum();
        int n = shifts.length;
        char arr[] = new char[n];
        for(int i = 0;i < n; i++) {
            long ch = s.charAt(i) - 'a';
            arr[i] = (char) (97+(ch + cumSum)%26);
            cumSum -= shifts[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n ;i++) {
            sb.append(arr[i]);
        }
        return sb.toString();

    }
} */

class Solution {
    public String shiftingLetters(String s, int[] shifts) {

        long cumSum = 0;
        int n = shifts.length;

        // suffix sum but modulo 26
        for (int i = n - 1; i >= 0; i--) {
            cumSum = (cumSum + shifts[i]) % 26;
        }

        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            arr[i] = (char) ('a' + (ch + cumSum) % 26);
            cumSum = (cumSum - shifts[i] % 26 + 26) % 26;
        }

        return new String(arr);
    }
}
