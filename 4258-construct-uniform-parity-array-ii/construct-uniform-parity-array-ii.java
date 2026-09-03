class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd = Integer.MAX_VALUE , eve = Integer.MAX_VALUE ;
        for(int i : nums1){
            if(i%2==0) eve = Math.min(i,eve) ;
            else odd = Math.min(i,odd) ;
        }
        if(odd == Integer.MAX_VALUE || odd < eve)return true ;
        return false ; 
    }
}