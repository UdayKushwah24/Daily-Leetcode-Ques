class Solution {
    class pair {
        int val;
        int setBit;
        public pair(int val, int setBit) {
            this.val = val;
            this.setBit = setBit;
        }
    }
    public int CountSetBit(int n) {
        int c = 0;
        while (n > 0) {
            c++;
            n = n & (n - 1);
        }
        return c;
    }

    public int[] sortByBits(int[] arr) {
        List<pair> ll = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            pair p = new pair(arr[i], CountSetBit(arr[i]));
            ll.add(p);
        }
        Collections.sort(ll, new Comparator<pair>() {
            @Override
            public int compare(pair p1, pair p2) {
                if (p1.setBit == p2.setBit) {
                    return p1.val - p2.val;
                } else {
                    return p1.setBit - p2.setBit;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            pair p = ll.get(i);
            arr[i] = p.val;
        }
        return arr;

    }
}