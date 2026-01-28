class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            List<Integer> temp = map.get(arr[i]);
            temp.add(i);
            map.put(arr[i], temp);
        }
        int n = arr.length;
        return bfs(map, arr);
    }

    public static int bfs(HashMap<Integer, List<Integer>> map, int[] arr) {
        int n = arr.length;
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int step = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int j = 0; j < s; j++) {
                int curr = q.poll();
                vis[curr] = true;
                 
                if (curr == n - 1) {
                    return step;
                }
                int left = curr - 1;
                int right = curr + 1;
                if (left >= 0) {
                    if (vis[left] == false) {
                        q.add(left);
                        vis[left] = true;
                    }
                }
                if (right < n) {
                    if (vis[right] == false) {
                        q.add(right);
                        vis[right] = true;
                    }
                }
                int val = arr[curr];
                if (map.containsKey(val)) {
                    List<Integer> rv = map.get(val);
                    for (int i = 0; i < rv.size(); i++) {
                        q.add(rv.get(i));
                        vis[rv.get(i)] = true;
                    }
                    map.remove(val);
                }
            }
            step++;
        }
        return -1;

    }
}