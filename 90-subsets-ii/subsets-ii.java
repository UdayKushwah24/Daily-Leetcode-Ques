class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> ll = new ArrayList<>();
        findUniqueSubsets(arr,set,ll,0);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> item : set){
            ans.add(item);
        }
        return ans;
    }
    public  void findUniqueSubsets(int arr[], Set<List<Integer>> set,List<Integer> ll,int idx){
        if(idx == arr.length){
            set.add(new ArrayList<>(ll));
            return;
        }
        findUniqueSubsets(arr,set,ll,idx+1);
        ll.add(arr[idx]);
        findUniqueSubsets(arr,set,ll,idx+1);
        ll.remove(ll.size()-1); 
    }
}