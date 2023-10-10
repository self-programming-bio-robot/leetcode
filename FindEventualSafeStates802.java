class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] safe = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (dps(graph, visited, safe, i)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dps(int[][] g, boolean[] v, boolean[] s, int i) {
        if (v[i]) {
            return s[i];
        }

        boolean safe = true;
        v[i] = true;

        for (int j: g[i]) {
            safe = safe & dps(g, v, s, j);
        }

        s[i] = safe;
        return safe;
    }
}
