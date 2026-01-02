
class Solution {

    class Node {
        int val;
        int rank;
        Node parent;
    }

    HashMap<Integer, Node> map = new HashMap<>();

    public void create(int v) {
        Node nn = new Node();
        nn.val = v;
        nn.rank = 0;
        nn.parent = nn;
        map.put(v, nn);
    }

    public int find(int v) {
        Node node = map.get(v);
        return find(node).val;
    }

    public Node find(Node node) {
        if (node.parent == node) {
            return node;
        }
        Node n = find(node.parent);
        node.parent = n;
        return n;
    }

    public void union(int v1, int v2) {
        Node node1 = map.get(v1);
        Node node2 = map.get(v2);
        Node re1 = find(node1);
        Node re2 = find(node2);
        if (re1.rank == re2.rank) {
            re1.parent = re2;
            re2.rank += 1;
        } else if (re1.rank < re2.rank) {
            re1.parent = re2;
        } else {
            re2.parent = re1;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        for (int e[] : edges) {
            if (!map.containsKey(e[0])) {
                create(e[0]);
            }
            if (!map.containsKey(e[1])) {
                create(e[1]);
            }
        }
        // 2. Edge process karo
        for (int[] e : edges) {
            int v1 = e[0];
            int v2 = e[1];

            // agar same parent hai -> cycle
            if (find(v1) == find(v2)) {
                return e;
            } else {
                union(v1, v2);
            }
        }

        return new int[0];

    }

}