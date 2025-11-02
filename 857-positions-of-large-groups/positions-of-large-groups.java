class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int idx = i;
            int c = 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                c += 1;
                i += 1;
            }
            if(c >= 3) {
                List<Integer> ll = new ArrayList<>();
                ll.add(idx);
                ll.add(i);
                ans.add(ll);
            }

        }
        return ans;
    }
}