/* class Solution {

    public int maxFrequency(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a: nums){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        int res = 0;
        for(int a: map.keySet()){
            res = Math.max(res, kedan(nums, k, a));
        }
        return map.getOrDefault(k,0)+res;
    }
    public int kedan(int[] nums, int k, int b){
        int res=0, curr= 0;
        for(int a: nums){
            if(k == a) curr--;
            if(a == b) curr++;
            if(curr < 0) curr = 0;
            res = Math.max(res, curr);

        }
        return res;

    }

} */

class Solution {
    public int maxFrequency(int[] nums, int k) {

        int base = 0;
        for (int x : nums)
            if (x == k) base++;

        int ans = base;

        Set<Integer> set = new HashSet<>();
        for (int x : nums)
            if (x != k) set.add(x);

        for (int v : set) {
            int cur = 0, best = 0;

            for (int x : nums) {
                if (x == v) cur++;
                else if (x == k) cur--;
                cur = Math.max(cur, 0);
                best = Math.max(best, cur);
            }
            ans = Math.max(ans, base + best);
        }
        return ans;
    }
}


// 3434