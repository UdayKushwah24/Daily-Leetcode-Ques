class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        int target = 0;
        for(int i = 0; i < n; i++) {
            int num1 = nums[i];
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int num2 = nums[j];
                int num3 = nums[k];
                int sum = num1 + num2 + num3;
                if(sum == target) {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(num1);
                    ll.add(num2);
                    ll.add(num3);
                    set.add(ll);
                    j++;
                    k--;
                }
                else if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            } 
        }

        // for(List<Integer> list : set) {
        //     ans.add(list);
        // }
          List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}