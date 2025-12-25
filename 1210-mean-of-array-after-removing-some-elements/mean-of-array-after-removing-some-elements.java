import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        
        int n = arr.length;
        int k = n * 5 / 100;   // 5% elements
        
        double sum = 0;
        
        for(int i = k; i < n - k; i++) {
            sum += arr[i];
        }
        
        return sum / (n - 2 * k);
    }
}
