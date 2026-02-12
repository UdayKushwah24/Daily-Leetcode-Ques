class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxL = 0;

        for( int i = 0; i < n; i++ ) {
            int[] arr = new int[26];

            for( int j = i; j < n; j++ ) {
                char ch = s.charAt(j);
                arr[ch - 'a'] += 1;

                if( checkBalanced(arr) ) {
                    maxL = Math.max( maxL, ( j - i + 1 ) );
                }
            }
        }
        return maxL;
    }

    private boolean checkBalanced(int[] arr) {
        int common = 0;
        for( int i = 0; i < 26; i++ ) {
            if( arr[i] == 0 ) continue;

            if( common == 0 ){
                common = arr[i];
            }
            else if( arr[i] != common  ) {
                return false;
            }
        }
        return true;
    }
}