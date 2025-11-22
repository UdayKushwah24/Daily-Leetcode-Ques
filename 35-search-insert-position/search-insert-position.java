/* class Solution {
    public int searchInsert(int[] nums, int target) {
        
    }

    public static int Search(int arr[],int target) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[start]>target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
    public static int InsertElement(int nums[],int target){
        int start = 0;
        int end = nums.length-1;
        int ans = 0;
        while (start <= end) {
            int mid = (start+end)/2;
            if(nums[mid] < target) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        } 
        return start;
    }

    public int searchInsert(int[] nums, int target) {
        
        if(Search(nums, target) == -1) {
            return InsertElement(nums, target);
        } else {
            return Search(nums, target);
        }
    }
} */



/* 
class Solution {

     public static int Search(int arr[],int target) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[start]>target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
    public static int InsertElement(int nums[],int target){
        int start = 0;
        int end = nums.length-1;
        int ans = 0;
        while (start <= end) {
            int mid = (start+end)/2;
            if(nums[mid] < target) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        } 
        return start;
    }

    public int searchInsert(int[] nums, int target) {
        
        if(Search(nums, target) == -1) {
            return InsertElement(nums, target);
        } else {
            return Search(nums, target);
        }
    }
} */



class Solution {
    public int searchInsert(int[] nums, int target) {
          int start = 0;
        int end = nums.length-1;
        int ans = 0;
        while (start <= end) {
            int mid = (start+end)/2;
            if(nums[mid] < target) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        } 
        return start;
    }
}