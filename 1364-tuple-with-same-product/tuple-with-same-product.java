class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productFreq = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                productFreq.put(product, productFreq.getOrDefault(product, 0) + 1);
            }
        }
        for (int count : productFreq.values()) {
            if (count > 1) {
                res += (count * (count - 1)) / 2;
            }
        }
        return res * 8;
    }
}