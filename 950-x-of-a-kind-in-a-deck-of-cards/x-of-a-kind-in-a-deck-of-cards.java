// class Solution {
//     public boolean hasGroupsSizeX(int[] deck) {
//         HashMap <Integer, Integer> map = new HashMap<>();
//         if(deck.length == 1) return false;
//         for(int i = 0; i< deck.length; i++) {
//             int key  = deck[i];
//             if(!map.containsKey(key)) map.put(key, 1);
//             else map.put(key, map.get(key)+1);
//         }
//         int arr[] = new int[map.size()];
//         int i =0;
//         for(int a : map.values()) {
//             arr[i] = a;
//             i++;
//         }
//         Arrays.sort(arr);
//         int div = arr[0];
//         for(int j = 1; j < arr.length; j++) {
//             if(arr[j] % div != 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean hasGroupsSizeX(int[] d) {
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for (int x : d) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        
        int g = 0;
        for (int v : m.values()) {
            g = gcd(g, v);
        }
        return g >= 2;
    }
    
    private int gcd(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        int hcf = 1;
        for(int i = 2; i <= Math.min(a, b); i++) {
            if(a%i == 0 && b %i==0){
                hcf = i;
            }
        }
        return hcf;
    }
}