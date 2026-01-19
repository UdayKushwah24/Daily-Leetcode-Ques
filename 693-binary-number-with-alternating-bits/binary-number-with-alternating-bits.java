class Solution {
    public boolean hasAlternatingBits(int n) {
        while (n > 0) {
			int rem = n % 2;
			n /= 2;
			int rem2 = n % 2;
			if ((rem == 1 && rem2 == 1) || (rem == 0 && rem2 == 0)) {
				return false;
			}
		}
		return true;
    }
}