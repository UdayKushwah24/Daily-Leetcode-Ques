class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            while (nums[i] > 0) {
                list.add(0, nums[i] % 10);
                nums[i] /= 10;
            }
            for (int j = 0; j < list.size(); j++) {
                ll.add(list.get(j));
            }
        }
        int ans[] = new int[ll.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ll.get(i);
        }
        return ans;
    }
}