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

    public int makeConnected(int n, int[][] connections) {

        if (n - 1 > connections.length)
            return -1;
        for (int i = 0; i < n; i++) {
            create(i);

        }

        int components = n;
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (find(u) != find(v)) {
                union(u, v);
                components--;
            }
        }
        return components - 1;
    }
}