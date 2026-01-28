class Solution {
    public int findTheWinner(int n, int k) {
         ArrayList<Integer> list = new ArrayList<>();
        // O(n)
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        // n^2
        while (list.size() > 1) {
            index = (index + (k-1)) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}