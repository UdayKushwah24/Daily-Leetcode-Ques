class Solution {
 
       public int maxNumberOfBalloons(String text) {
    Map<Character, Integer> freq = new HashMap<>();

    // Count frequency of all characters
    for (char c : text.toCharArray()) {
        freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    // balloon needs: b(1), a(1), l(2), o(2), n(1)
    int b = freq.getOrDefault('b', 0);
    int a = freq.getOrDefault('a', 0);
    int l = freq.getOrDefault('l', 0) / 2;
    int o = freq.getOrDefault('o', 0) / 2;
    int n = freq.getOrDefault('n', 0);

    return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
}
     
}