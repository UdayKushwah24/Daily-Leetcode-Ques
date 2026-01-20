class Solution {
    private int countBit(int i) {
		int c = 0;
		while (i > 0) {
			if (i % 2 == 1) {
				c++;
			}
			i /= 2;
		}
		return c;
	}
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (k == countBit(i)) {
				sum += nums.get(i);
			}
		}
		return 
        sum;
    }
}