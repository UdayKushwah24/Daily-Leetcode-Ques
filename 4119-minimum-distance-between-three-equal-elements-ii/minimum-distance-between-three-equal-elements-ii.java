// class Solution {
//     public int minimumDistance(int[] nums) {
//         HashMap<Integer , List<Integer>> map = new HashMap<>();
//         for(int i = 0; i < nums.length; i++) {
//             if(!map.containsKey(nums[i])) {
//                 map.put(nums[i], new ArrayList<>());
//             }
//             map.get(nums[i]).add(i);
//         }
//         int ans = Integer.MAX_VALUE;
//         for(int key : map.keySet()) {
//             List<Integer> ll = map.get(key);
//             int val = max(ll);
//             if(val != -1) {
//                 ans = Math.min(ans, val);
//             }
//             ans = Math.max(ans, max(ll));
//         }
//         //  System.out.println(map);
//         return ans==Integer.MAX_VALUE ? -1 : ans ;
//     }
//     public static int max(List<Integer> ll) {
//         int n = ll.size();
//         int diff = -1;
//         for(int i = 0; i < n; i++) {
//             int l = i+1;
//             int r = n-1;
//             while(l < r) {
//                 int abs_sum = Math.abs(ll.get(i) - ll.get(l)) + Math.abs(ll.get(l) - ll.get(r)) + Math.abs(ll.get(i) - ll.get(r));
//                 if(diff < abs_sum) {
//                     diff = abs_sum;
//                     l++;
//                 } else {
//                     r--;
//                 }
//             }
//         }
//         return diff;
//     }
// }





class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        
        int ans = Integer.MAX_VALUE; // change
        
        for(int key : map.keySet()) {
            List<Integer> ll = map.get(key);
            int val = max(ll);
            if(val != -1) {
                ans = Math.min(ans, val); // change
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans; // change
    }

    public static int max(List<Integer> ll) {
        int n = ll.size();
        if(n < 3) return -1; // important
        
        int diff = Integer.MAX_VALUE;
        
        // only check triplets of size 3 (consecutive)
        for(int i = 0; i <= n - 3; i++) {
            int a = ll.get(i);
            int b = ll.get(i + 1);
            int c = ll.get(i + 2);
            
            int abs_sum = Math.abs(a - b) + Math.abs(b - c) + Math.abs(a - c);
            diff = Math.min(diff, abs_sum);
        }
        
        return diff;
    }
}