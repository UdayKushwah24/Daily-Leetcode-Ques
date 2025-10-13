package InfinityChampionsProgram.Day1;
 
public class MaximumCircularSum {
    public static void main(String[] args) {
        int[] arr = { 2, 1, -5, 4, -3, 1, -3, 4, -1 };
        int withoutCircular = kadanes(arr);


        // int sum = Arrays.stream(arr).sum();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] *= -1;
        }
        int maxLinear = kadanes(arr);
        if (sum + maxLinear == 0) {
            System.out.println(withoutCircular);
        }
        
        System.out.println(Math.max(withoutCircular, sum + maxLinear));

    }

    public static int kadanes(int arr[]) {
        int sum = arr[0];
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum < arr[i]) {
                sum = arr[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    
}
