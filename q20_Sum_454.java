package DailyLeetcodeQuestion;

public class q20_Sum_454 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int c = 0;
        for (int i = 0; i < nums4.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                for (int j2 = 0; j2 < nums4.length; j2++) {
                    for (int k = 0; k < nums4.length; k++) {
                        if (nums1[i] + nums2[j] + nums3[j2] + nums4[k] == 0) {
                            c += 1;
                        }
                    }
                }
            }
        }
        return c;
    } 
}
