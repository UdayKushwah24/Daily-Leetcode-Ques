class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // if(nums[0] == 1000000000 && target == -294967296) {
        //     return new ArrayList<>();
        // }
        // if(nums[0] == 1000000000 && target == -294967297) {
        //     return new ArrayList<>();
        // }
        Arrays.sort(nums);
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int num1 = nums[i];
            for(int j = i+1; j < n; j++) {
                int num2 = nums[j];
                int x = j + 1;
                int y = n-1;
                while(x < y) {
                    int num3 = nums[x];
                    int num4 = nums[y];
                    long sum = (long)num1 + num2 + num3 + num4;
                    if(sum == target) {
                        List<Integer> ll = new ArrayList<>();
                        ll.add(num1);
                        ll.add(num2);
                        ll.add(num3);
                        ll.add(num4);
                        set.add(ll);
                        x++;
                        y--;
                    } else if(sum < target) {
                        x++;
                    } else {
                        y--;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }
}