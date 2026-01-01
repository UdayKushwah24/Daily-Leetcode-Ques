class Solution {

    class Node {
        Node[] children = new Node[26];
        boolean eow;
    }

    // Trie root
    Node root;

    // Memoization array
    Boolean[] memo;

    // Insert word into Trie
    public void insert(String word, Node root) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Search exact word in Trie
    public boolean search(String word, Node root) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    // Main Word Break function
    public boolean wordBreak(String s, List<String> wordDict) {

        // fresh trie for every test case
        root = new Node();

        // build trie
        for (String word : wordDict) {
            insert(word, root);
        }

        // memoization by remaining string length
        memo = new Boolean[s.length() + 1];

        return dfs(s, root);
    }

    // DFS + Memoization
    private boolean dfs(String s, Node root) {
        if (s.length() == 0) return true;

        int len = s.length();
        if (memo[len] != null) return memo[len];

        for (int i = 1; i <= s.length(); i++) {
            String first = s.substring(0, i);
            String second = s.substring(i);

            if (search(first, root) && dfs(second, root)) {
                return memo[len] = true;
            }
        }

        return memo[len] = false;
    }
}
