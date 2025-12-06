class Solution {
    public int[] minOperations(int[] nums) {
        int[] ravineldor = nums;
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            int uppper = x, neeche = x, ops = 0;

            while(true){
                if(function_to_check_palin(uppper)){
                    ans[i] = ops;
                    break;
                }
                
                if(function_to_check_palin(neeche) && neeche >= 0){
                    ans[i] = ops;
                    break;
                }
                uppper++;
                neeche--;
                ops++;
            }
        }
        return ans;
    }

    private boolean function_to_check_palin(int n){
        String s = Integer.toBinaryString(n);
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
