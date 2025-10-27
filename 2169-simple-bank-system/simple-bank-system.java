class Bank {
    HashMap<Integer, Long> map = new HashMap<>();

    public Bank(long[] balance) {
        for (int i = 0; i < balance.length; i++) {
            map.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if(!map.containsKey(account1) || !map.containsKey(account2)) return false;
        if (map.get(account1) < money)
            return false;
        else {
            map.put(account1, map.get(account1) - money);
            map.put(account2, map.get(account2) + money);
            return true;
        }
    }

    public boolean deposit(int account, long money) {
        if(!map.containsKey(account)) return false;
        else {
            map.put(account, map.get(account) + money);

            return true;
        }
    }

    public boolean withdraw(int account, long money) {
        if (!map.containsKey(account) || map.get(account) < money)
            return false;
        else {
            map.put(account, map.get(account) - money);

            return true;
        }
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */