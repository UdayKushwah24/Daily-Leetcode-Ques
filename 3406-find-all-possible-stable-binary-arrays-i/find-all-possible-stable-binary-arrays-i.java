class Solution {
    public int numberOfStableArrays(int z,int o,int l){
        int mod=1000000007;
        long[][] d0=new long[z+1][o+1];
        long[][] d1=new long[z+1][o+1];
        for(int i=1;i<=Math.min(z,l);i++) d0[i][0]=1;
        for(int j=1;j<=Math.min(o,l);j++) d1[0][j]=1;
        for(int i=1;i<=z;i++){
            for(int j=1;j<=o;j++){
                for(int k=1;k<=l && k<=i;k++)
                    d0[i][j]=(d0[i][j]+d1[i-k][j])%mod;
                for(int k=1;k<=l && k<=j;k++)
                    d1[i][j]=(d1[i][j]+d0[i][j-k])%mod;
            }
        }

        return (int)((d0[z][o]+d1[z][o])%mod);
    }
}