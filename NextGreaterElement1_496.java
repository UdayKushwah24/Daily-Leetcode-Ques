package InfinityChampionsProgram.Day6;

import java.util.HashMap;

public class NextGreaterElement1_496 {

   /*  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int ans[] = new int[nums1.length];
      for (int i = 0; i < ans.length; i++) {
          for (int j = i; j < nums2.length; j++) {
              if (nums2[j] > nums1[i]) {
                  ans[i] = nums2[j];
                  nums2[j] = -1; 
                  break;
              } else {
                  ans[i] = -1;
              }
          }
      }
   
   
      return ans;
   } */
   
   
   public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

       HashMap<Integer, Integer> map = new HashMap<>();

       for (int i = 0; i < nums2.length; i++) {
           map.put(nums2[i], i);
       }
       int ans[] = new int[nums1.length];
       for (int i = 0; i < ans.length; i++) {
           int idx = map.get(nums1[i]);
            for (int j = idx; j < nums2.length; j++) {
                 
                    if (nums2[j] > nums1[i]) {
                        ans[i] = nums2[j];
                        break;
                    } else {
                        ans[i] = -1;
                    }
                
            }
       }

       return ans;
   }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
        int ans[] = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
