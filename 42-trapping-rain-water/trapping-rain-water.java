class Solution{
    public int trap(int[] h){
        int n=h.length;
        if(n==0)return 0;
        int l=0,r=n-1;
        int lm=0,rm=0;
        int w=0;
        while(l<r){
            if(h[l]<=h[r]){
                if(h[l]>=lm)lm=h[l];
                else w+=lm-h[l];
                l++;
            }else{
                if(h[r]>=rm)rm=h[r];
                else w+=rm-h[r];
                r--;
            }
        }
        return w;
    }
}
   