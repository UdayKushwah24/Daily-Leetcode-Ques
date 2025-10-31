class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < arr.length; i++) {
            arr[nums[i]]++;
        }
        List<Integer> ll = new ArrayList<>();
        for(int i = 0; i < arr.length; i++ ) {
            if(arr[i] == 2) {
                ll.add(i);
            }
        }
        int ans[] = new int[ll.size()];
        for(int i = 0  ; i < ans.length;i++) {
            ans[i] = ll.get(i);
        }
        return ans;
    }
}