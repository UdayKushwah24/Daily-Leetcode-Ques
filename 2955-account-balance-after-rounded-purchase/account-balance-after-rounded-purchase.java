class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int ans = 0;
        String s = purchaseAmount+"";
         if(purchaseAmount == 100) return 0;
        if(s.length() == 1) {
            if(purchaseAmount < 5) return 100;
            else return 90;
        } 
        if(s.length() == 2) {
            int x = s.charAt(0)-'0';
            if(s.charAt(1) == '0' ||  s.charAt(1)-'0' < 5) x--;
            return 100 - (x+1)*10;
        }
        return 0;
    }
}