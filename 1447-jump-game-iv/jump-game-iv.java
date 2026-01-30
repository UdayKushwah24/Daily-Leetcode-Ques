/* class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            List<Integer> ll = map.get(arr[i]);
            ll.add(i);
            map.put(arr[i], ll);
        }
        return solve(arr, map);
    }

    public int solve(int[] arr, HashMap<Integer, List<Integer>> map) {
        Queue<Integer> q = new LinkedList<>();
        int n  = arr.length;
        boolean [] vis = new boolean[n];
        q.add(0);
         vis[0] = true;
        int jump = 0;
        while(!q.isEmpty()) {
            int s = q.size();
            for(int i = 0; i < s; i++) {
                int cc = q.poll();
                if(cc == n-1) return jump;
                int left = cc -  1;
                int right = cc + 1;
                if(left >= 0 && vis[left] == false) {
                    q.add(left);
                    vis[left] = true;
                }
                if(right < n && vis[right] == false) {
                    q.add(right);
                    vis[right] = true;
                }

                if(map.containsKey(arr[cc])) {
                    for(int val : map.get(arr[cc])) {
                        q.add(val);
                        vis[val] = true;
                    }
                    map.remove(arr[cc]);
                }
            }
            jump++;
        }
        return -1;
    }
} */


class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            List<Integer> ll = map.get(arr[i]);
            ll.add(i);
            map.put(arr[i], ll);
        }
        return solve(arr, map);
    }

    public int solve(int[] arr, HashMap<Integer, List<Integer>> map) {
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length;
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;
        int jump = 0;
        while(!q.isEmpty()) {
            
            int s = q.size();
            for(int i = 0; i < s ; i++) {
                int cc = q.poll();
                int left = cc - 1;
                int right = cc +1;
                if(cc == n-1) return jump;
                if(left >= 0 && !vis[left]) {
                    q.add(left);
                    vis[left ] = true;
                }

                if(right < n && !vis[right]) {
                    q.add(right);
                    vis[right] = true;
                }

                if(map.containsKey(arr[cc])) {
                    for(int ele : map.get(arr[cc])) {
                        q.add(ele);
                        vis[ele] = true;
                    }
                    map.remove(arr[cc]);
                }
            }
            jump++;
        }
        return -1;
    }
}


















