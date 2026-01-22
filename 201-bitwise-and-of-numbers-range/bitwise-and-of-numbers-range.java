class Solution {
    public int rangeBitwiseAnd(int left, int right) {
         int shiftbit = 0;
         while(left != right) {
            left >>= 1;
            right >>= 1;
            shiftbit++;
         }

         return (left << shiftbit);
    }
}