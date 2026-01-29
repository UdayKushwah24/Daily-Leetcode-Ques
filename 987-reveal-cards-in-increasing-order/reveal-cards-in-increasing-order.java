// class Solution {
//     public int[] deckRevealedIncreasing(int[] deck) {
//         Arrays.sort(deck);

//         int n = deck.length;
//         int[] ans = new int[n];

//         boolean skip = false;
//         int placed = 0;   // how many cards placed
//         int p = 0;        // pointer in deck
//         int i = 0;        // circular index

//         while (placed < n) {
//             if (ans[i] == 0) {              // empty position
//                 if (!skip) {
//                     ans[i] = deck[p++];
//                     placed++;
//                 }
//                 skip = !skip;
//             }
//             i = (i + 1) % n;                // circular move
//         }

//         return ans;
//     }
// }

/* 
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;
        int[] ans = new int[n];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(i);
        }

        for (int card : deck) {
            int idx = q.poll();     // reveal position
            ans[idx] = card;

            if (!q.isEmpty()) {
                q.offer(q.poll()); // move next to bottom
            }
        }

        return ans;
    }
}
 */

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;
        int[] ans = new int[n];
        boolean skip = false;
        int placed = 0;
        int i = 0;
        int p = 0;
        while (placed < n) {
            if (ans[i] == 0) {
                if (!skip) {
                    ans[i] = deck[p++];
                    placed++;
                }
                skip = !skip;
            }
            i = (i + 1) % n;
        }

        return ans;
    }
}
