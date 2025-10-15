package Graph;

import java.util.*;

public class GraphValidTree {

    public static boolean ValidTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        boolean isValid = DFT(map);
        return isValid;

    }

    // DFT

    public static boolean DFT(HashMap<Integer, List<Integer>> map) {
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        int component = 0;
        for (int src : map.keySet()) {
            if (visited.contains(src)) {
                continue;
            }
            st.push(src);
            while (!st.isEmpty()) {
                // 1. remove
                int r = st.pop();
                // Ignore if already visited
                if (visited.contains(r)) {
                    return false;
                }
                // 3. Marked visited
                visited.add(r);
                // 4. self work
                System.out.print(r + " ");
                // 5. Add unvisited nbsrs
                for (int nbrs : map.get(r)) {
                    if (!visited.contains(nbrs)) {
                        st.push(nbrs);
                    }
                }
            }
            component++;
        }
        return component == 1;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println(ValidTree(n, edges));
    }

}
