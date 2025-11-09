class Solution {
    public long maxArrayValue(int[] nums) {
        List<Long> ll = new ArrayList<>();
        for(long a : nums) {
            ll.add(a);
        }

        for(int i = ll.size()-2; i >= 0; i--) {

            if(ll.get(i) <= ll.get(i+1)) {
                ll.set(i, ll.get(i) + ll.get(i+1));
                ll.remove(i+1);
            }
        }
        return ll.get(0);
    }
}