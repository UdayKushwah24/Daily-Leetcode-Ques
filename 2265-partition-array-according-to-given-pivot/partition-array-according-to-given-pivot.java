class Solution {
   
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
		int index = 0;

		// Part 1: Add elements less than pivot
		for (int num : nums) {
			if (num < pivot) {
				ans[index++] = num;
			}
		}

		// Part 2: Add elements equal to pivot
		for (int num : nums) {
			if (num == pivot) {
				ans[index++] = num;
			}
		}

		// Part 3: Add elements greater than pivot
		for (int num : nums) {
			if (num > pivot) {
				ans[index++] = num;
			}
		}

		return ans;
    }
}