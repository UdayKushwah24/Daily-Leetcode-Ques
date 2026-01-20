class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }

        for (String str : words) {
            boolean flag = true;
            for (char ch : str.toCharArray()) {
                if(!set.contains(ch)) {
                    flag = false;
                }
            }
            if(flag)
            ans++;
        }
        return ans;
    }
}