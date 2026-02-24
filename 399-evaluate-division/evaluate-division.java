class Solution {
    HashMap<String, HashMap<String, Double>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            double val = values[i];
            if (!map.containsKey(s1)) {
                map.put(s1, new HashMap<>());
            }
            if (!map.containsKey(s2)) {
                map.put(s2, new HashMap<>());
            }
            map.get(s1).put(s2, val);
            map.get(s2).put(s1, 1 / val);
        }

        int q = queries.size();
        double ans[] = new double[q];
        for (int i = 0; i < q; i++) {
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            if (!map.containsKey(s1) || !map.containsKey(s2)) {
                ans[i] = -1;
            } else if(s1.equals(s2)) {
                ans[i] = 1;
            } else {
                ans[i] = dfs(s1, s2, 1.0, new HashSet<>());
            }
        }

        return ans;
    }
    public double dfs(String src, String des, double pro, HashSet<String> vis) {
        if(src.equals(des)) return pro;
        vis.add(src);
        for(String nbrs : map.get(src).keySet()) {
            if(!vis.contains(nbrs)) {
               double val = dfs(nbrs, des, pro * map.get(src).get(nbrs), vis);
               if(val != -1) return val;
            }
        }
        return -1;
    }
}