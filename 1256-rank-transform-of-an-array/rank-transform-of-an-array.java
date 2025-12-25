class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] copy = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy);
        int rank = 1;
        for(int e : copy) {
            if(map.containsKey(e)) continue;
            map.put(e, rank);
            rank++;
        }
        for(int i = 0; i < arr.length;i++) {
            copy[i] = map.get(arr[i]);
        }
        return copy;
    }
}