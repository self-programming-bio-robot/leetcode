class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> links = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }

        boolean[] v = new boolean[n];
        for (int i = 0; i < connections.length; i++) {
            int j = connections[i][0];
            int k = connections[i][1];
            links.get(j).add(k + 1);
            links.get(k).add(-j - 1);
        }

        return dfs(0, links, v);
    }

    private int dfs(int i, List<List<Integer>> links, boolean[] v) {
        int res = 0;
        v[i] = true;
        
        for (Integer next: links.get(i)) {
            int j = Math.abs(next) - 1;
            if (v[j]) continue;
            if (next > 0) res += 1;
            res += dfs(j, links, v);
        }

        return res;
    }
}