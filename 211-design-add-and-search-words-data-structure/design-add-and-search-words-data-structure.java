class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean eow;
    }

    Node root = new Node();

    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, Node node) {
        if (node == null) return false;

        if (i == word.length()) {
            return node.eow;
        }

        char ch = word.charAt(i);

        // wildcard case
        if (ch == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null) {
                    if (dfs(word, i + 1, node.children[j])) {
                        return true;
                    }
                }
            }
            return false;
        }
        // normal character
        else {
            int idx = ch - 'a';
            return dfs(word, i + 1, node.children[idx]);
        }
    }
}
