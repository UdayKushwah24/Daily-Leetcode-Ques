class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int i=0;
        int n=Math.min(s1.length(),Math.min(s2.length(),s3.length()));
        int ans=-1;
        for(i=0;i<n;i++){
            if(s1.charAt(i)==s2.charAt(i)&&s2.charAt(i)==s3.charAt(i)){
                continue;
            }
            break;
        }
        if(i==0){
            return -1;
        }
        ans=0;
        ans+=s1.length()-i;
        ans+=s2.length()-i;
        ans+=s3.length()-i;
        return ans;
    }
}