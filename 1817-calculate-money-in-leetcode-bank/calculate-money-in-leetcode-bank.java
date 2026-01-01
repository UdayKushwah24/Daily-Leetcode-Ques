class Solution {
    public int totalMoney(int n) {
        int amount = 0;
        int money = 1;
        int idx = 1;

        for (int i = 1; i <= n; i++) {
            amount += money;

            // every 7th day, reset for next week
            if (i % 7 == 0) {
                idx++;
                money = idx;
            } else {
                money++;
            }
        }
        return amount;
    }
}
