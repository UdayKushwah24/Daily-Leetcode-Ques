class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) count++;
            set.add(arr[i]);
        }
        if(count > 1) return true;
        for(int i = 0; i < arr.length; i++) {

            if(arr[i] != 0 && set.contains(2*arr[i])) return true;
        }
        return false;
    }
}