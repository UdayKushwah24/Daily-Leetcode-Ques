class Solution {
     
    public   int minDays(int[] bloomDay, int m, int k) {
        
        if ((long)m*k > bloomDay.length) {
            return -1;
        }
        int ans = -1;
        int low = 1;
        int high = Arrays.stream(bloomDay).max().getAsInt()+1 ;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private   boolean isPossible(int[] bloomDay, int makebouquq, int k, int day) {
         int count = 0;
        int countBouquet = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                count = 0;
            }
            if(count == k) {
                count=0;
                countBouquet++;
            }
            if(countBouquet >= makebouquq) return true;
        }
        return  false;
    }
 
}