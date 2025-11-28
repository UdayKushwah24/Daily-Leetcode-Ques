class Solution {
    public int triangularSum(int[] nums) {
           List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        while (list.size() > 1) {

            List<Integer> ll = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                ll.add((list.get(i) + list.get(i + 1)) % 10);

            }
            // while (!list.isEmpty()) {
            //     list.removeFirst();
            // }
            list.clear();
            for (int i = 0; i < ll.size(); i++) {
                list.add(ll.get(i));
            }
        }
        return list.get(0);
    }
}