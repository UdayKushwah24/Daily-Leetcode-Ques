/* class Solution {
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
} */

class Solution {
    public int longestBalanced(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i; j < n; j++) {
                int ch = s.charAt(j) - '0';
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(checkBalanced(map)) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }

    public boolean checkBalanced(HashMap<Integer , Integer> map) {
        int common =0 ;
        for(int val : map.values()) {
            if(common == 0)  common = val;
            if(common != val) return false;
        }
        return true;
    }
}