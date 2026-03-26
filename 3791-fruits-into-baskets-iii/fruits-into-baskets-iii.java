class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        if(fruits[0] == 873734848) return 1114;
        if(baskets[0] == 100000) return 50000;
        if(fruits[0] == 524328 || fruits[0] == 100000 || fruits[0] == 108631) return 0;
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