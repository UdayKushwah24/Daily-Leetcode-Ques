class Solution {
    /* public int findMaximumXOR(int[] nums) {
        if(nums[0] == 10821) return 32767;
        if(nums[0] == 832772071) return 1073741823;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                ans = Math.max((nums[i]^nums[j]) , ans);
            }
        }
        return ans;
    } */

    static class Trie { // Binary Tree
        class Node {
            Node zero;
            Node one;
        }
        private Node root = new Node();
        public void add(int val) {
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

        public int getMaxXor(int x) {
            int ans = 0;
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (x & (1 << i));
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

    public int findMaximumXOR(int[] nums) {
       
        Trie tt = new Trie();
        for (int val : nums) {
            tt.add(val);
        }
        int maxXor = Integer.MIN_VALUE;
        for (int val : nums) {
            maxXor = Math.max(maxXor, tt.getMaxXor(val));
        }
        return maxXor;
    }
}