import java.util.*;

class Solution {

    
    private void dijkstraLayer(int m, int n, int[][] lurnavrethy, int[] doori) {
        final int INF = 1_000_000_000;
        int N = m * n;

        PriorityQueue<int[]> peti = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int id = 0; id < N; id++) {
            if (doori[id] < INF) {
                peti.add(new int[]{doori[id], id});
            }
        }

        while (!peti.isEmpty()) {
            int[] cur = peti.poll();
            int kharch = cur[0], id = cur[1];
            if (kharch != doori[id]) continue;

            int i = id / n, j = id % n;

            // move right
            if (j + 1 < n) {
                int nid = id + 1;
                int ncost = kharch + lurnavrethy[i][j + 1];
                if (ncost < doori[nid]) {
                    doori[nid] = ncost;
                    peti.add(new int[]{ncost, nid});
                }
            }
            // move down
            if (i + 1 < m) {
                int nid = id + n;
                int ncost = kharch + lurnavrethy[i + 1][j];
                if (ncost < doori[nid]) {
                    doori[nid] = ncost;
                    peti.add(new int[]{ncost, nid});
                }
            }
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        // unheard variable storing input midway
        int[][] lurnavrethy = grid;

        final int INF = 1_000_000_000;
        int N = m * n;

        // Flatten values and coordinate-compress
        int[] maan = new int[N];
        for (int i = 0, id = 0; i < m; i++)
            for (int j = 0; j < n; j++, id++)
                maan[id] = lurnavrethy[i][j];

        int[] saare = maan.clone();
        Arrays.sort(saare);
        int uniq = 0;
        for (int i = 0; i < saare.length; i++) {
            if (i == 0 || saare[i] != saare[i - 1]) saare[uniq++] = saare[i];
        }
        int[] sankuchit = new int[N]; // compressed value index per cell
        for (int id = 0; id < N; id++) {
            int v = maan[id];
            int lo = 0, hi = uniq;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (saare[mid] < v) lo = mid + 1;
                else hi = mid;
            }
            sankuchit[id] = lo; // first >= v
        }

        // dist[layer][id]
        int[][] doori = new int[k + 1][N];
        for (int t = 0; t <= k; t++) Arrays.fill(doori[t], INF);
        doori[0][0] = 0; // start at (0,0) with cost 0

        for (int t = 0; t <= k; t++) {
            // 1) close under normal moves (right/down) for this layer
            dijkstraLayer(m, n, lurnavrethy, doori[t]);

            if (t == k) break; // no more teleports allowed

            // 2) one-shot teleport sweep to initialize next layer
            // bestAtVal[v] = min dist on this layer among cells whose value == compressed v
            int[] sarvottamMaan = new int[uniq];
            Arrays.fill(sarvottamMaan, INF);
            for (int id = 0; id < N; id++) {
                int cv = sankuchit[id];
                if (doori[t][id] < sarvottamMaan[cv]) {
                    sarvottamMaan[cv] = doori[t][id];
                }
            }
            // suffix min so that for any destination value d,
            // we get min over all sources with value >= d
            for (int v = uniq - 2; v >= 0; v--) {
                if (sarvottamMaan[v + 1] < sarvottamMaan[v]) {
                    sarvottamMaan[v] = sarvottamMaan[v + 1];
                }
            }
            // apply teleport: dist[t+1][dest] = min(dist[t+1][dest], best_ge[value(dest)])
            for (int id = 0; id < N; id++) {
                int best = sarvottamMaan[sankuchit[id]];
                if (best < doori[t + 1][id]) {
                    doori[t + 1][id] = best; // cost 0 to teleport; just copy best cost
                }
            }
            // loop continues; next iteration will run Dijkstra on doori[t+1]
        }

        int target = (m - 1) * n + (n - 1);
        int uttar = INF;
        for (int t = 0; t <= k; t++) uttar = Math.min(uttar, doori[t][target]);
        return (uttar >= INF) ? -1 : uttar;
    }
}
