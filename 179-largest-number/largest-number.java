class Solution {
    public String largestNumber(int[] arr) {
        
        boolean is_0_arr = true;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                is_0_arr = false;
            }
        }
        if(is_0_arr) {
            return "0";
        }
        
        int n = arr.length;
        for(int i = 0;i < n;i++){
            for (int j = i+1; j < n; j++) {
                String num_i = ""+arr[i];
                String num_j = ""+arr[j];
                String num_i_add_num_j = num_i + num_j;
                String num_j_add_num_i = num_j + num_i;
                if(num_j_add_num_i.compareTo(num_i_add_num_j) > 0){ 
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int ele : arr) {
            ans.append(ele);
        }
        return ans.toString();
    }
}