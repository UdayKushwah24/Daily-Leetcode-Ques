/* class Solution {
   public   String replaceWords(List<String> dictionary, String sentence) {
        String arr[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < dictionary.size(); i++) {
            set.add(dictionary.get(i));
        }

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            sb.append(findRoot(word, set) + " ");
        }
        return sb.toString().trim();
    }

    private   String findRoot(String word, HashSet<String> set) {
        for (int i = 1; i < word.length(); i++) {
            String s = word.substring(0, i);
            if (set.contains(s)) {
                return s;
            }
        }
        return word;
    }
} */

class Solution {

    class Node {

        char ch;
        String isterminal;
        HashMap<Character, Node> child;

        public Node(char ch) {
            this.ch = ch;
            child = new HashMap<>();
        }
    }

    private Node root;

    public Solution() {
        root = new Node('*');
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.child.containsKey(ch)) { // common prefix
                curr = curr.child.get(ch);
            } else {
                Node nn = new Node(ch);
                curr.child.put(ch, nn);
                curr = nn;
            }
        }
        curr.isterminal = word;
    }

    public String search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.child.containsKey(ch)) {
                curr = curr.child.get(ch);
                if (curr.isterminal != null) {
                    return curr.isterminal;
                }
            } else {
                return word;
            }
        }
        return word;
    }

    public   String replaceWords(List<String> dictionary, String sentence) {

        String arr[] = sentence.split(" ");
        
        for (String d : dictionary) {
            insert(d);
        }
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(search(s) +" ") ;
        }
        return sb.toString().trim();
    }


}