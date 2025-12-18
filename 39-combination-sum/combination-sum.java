class Solution {
    /* public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Combination(candidates, target, lst,0,ans);
        return ans;
    }


    public static void Combination(int[] coin, int amount, List<Integer> lst,int idx, List<List<Integer>> ans) {
        if(amount == 0) {
            ans.add(new ArrayList<>(lst));
            return;
        }
        for (int i = idx; i < coin.length; i++) {
            if(amount >= coin[i]) {
                lst.add(coin[i]);
                Combination(coin, amount-coin[i], lst,i,ans);
                lst.remove(lst.size()-1);
            }
        }
    } */


    /* public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Combination(ans,candidates, 0,   target,lst, 0);
        return ans;
    }


     public static void Combination(List<List<Integer>> ans,int[] coin, int curr , int amount, List<Integer> lst, int idx) {
        if(amount == curr) {
            ans.add(new ArrayList<>(lst));
            return;
        }
         
        for (int i = idx; i < coin.length; i++) {
            if(curr <= amount) {
                lst.add(coin[i]);
                Combination(ans,coin, curr+coin[i], amount , lst, i);
                lst.remove(lst.size()-1);
            }
        }
    }  */



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Combination(list,ll, candidates, target,0);
        return list;
    }
    public static void Combination(List<List<Integer>> list,  List<Integer> ll,int[] candidates, int target , int idx) {
        if(0 == target) {
            list.add(new ArrayList<>(ll));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if(target>= candidates[i]) {
                ll.add(candidates[i]);
                Combination(list, ll, candidates, target-candidates[i],i);
                ll.remove(ll.size()-1);
            }
        }
    }
}