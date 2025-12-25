class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for(int e : candyType) {
            set.add(e);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}