class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        int n = fruits.length;
        for(int i = 0;i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(baskets[j] == -1) continue;
                if(baskets[j] >= fruits[i]) {
                    baskets[j] = -1;
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }
}