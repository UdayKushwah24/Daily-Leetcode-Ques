class Solution {
    public int subsetXORSum(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Subset(arr,list,ll,0);
        int xor = 0;
        for (int i = 0; i < list.size(); i++) {
            int c = 0;
            for (int j = 0; j < list.get(i).size(); j++) {
                c ^= list.get(i).get(j);
            }
            xor += c;
        }
        return xor;
    }
    // find all possible subset of given array
    public static void Subset(int[] arr,List<List<Integer>> list, List<Integer> ll, int i) {
         
        if(arr.length == i) {
            list.add(new ArrayList<>(ll));
            return;
        }
        Subset(arr,list, ll, i+1);
        ll.add(arr[i]);
        Subset(arr, list, ll, i+1);
        ll.remove(ll.size()-1);
    }
}