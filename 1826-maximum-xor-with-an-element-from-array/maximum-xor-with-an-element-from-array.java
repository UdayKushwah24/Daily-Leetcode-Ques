class Solution {
   
    static class Trie {

        class Node {

            Node one;
            Node zero;
        }

        private Node root = new Node();

        public void insert(int val) {
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (val & (1 << i));
                if (bit == 0) {
                    if (curr.zero != null) {
                        curr = curr.zero;
                    } else {
                        Node nn = new Node();
                        curr.zero = nn;
                        curr = nn;
                    }
                } else {
                    if (curr.one != null) {
                        curr = curr.one;
                    } else {
                        Node nn = new Node();
                        curr.one = nn;
                        curr = nn;
                    }
                }
            }
        }

        public int getMaxXOR(int val) {
            int ans = 0;
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (val & (1 << i));
                if (bit == 0) {
                    if (curr.one != null) {
                        ans = (ans | (1 << i));
                        curr = curr.one;
                    } else {
                        curr = curr.zero;
                    }
                } else {
                    if (curr.zero != null) {
                        ans = (ans | (1 << i));
                        curr = curr.zero;
                    } else {
                        curr = curr.one;
                    }
                }
            }

            return ans;
        }
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        int q = queries.length;
        int[][] newQueries = new int[q][3];
        for (int i = 0; i < q; i++) {
            newQueries[i][0] = queries[i][0]; // xi
            newQueries[i][1] = queries[i][1]; // mi
            newQueries[i][2] = i;             // original index
        }

        Arrays.sort(newQueries, (a, b) -> (a[1] - b[1]));
       /*  for (int i = 0; i < q; i++) {
            System.out.println(newQueries[i][0] + " " + newQueries[i][1] + " " + newQueries[i][2]);
        } */

        Trie trie = new Trie();
        int[] ans = new int[q];
        int i = 0;
        for (int[] query : newQueries) {
            int xi = query[0];
            int mi = query[1];
            int idx = query[2];

            while(i < nums.length && nums[i] <= mi) {
                trie.insert(nums[i]);
                i++;
            }

             if (i == 0) {
                ans[idx] = -1;
            } else {
                ans[idx] = trie.getMaxXOR(xi);
            }
        }

        return ans;

    }
}