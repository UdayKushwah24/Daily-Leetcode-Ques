/* class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      
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
} */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1;
                int r = n - 1;

                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;

                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;

                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
