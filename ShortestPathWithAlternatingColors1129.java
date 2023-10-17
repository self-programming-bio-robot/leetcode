class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // create hash map by edges where key is start node, value is destinations
        // write method DFS
        Map<Integer, List<Integer>> re = new HashMap<>();
        Map<Integer, List<Integer>> be = new HashMap<>();

        for (int[] e: redEdges) {
            re.compute(e[0], (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(e[1]);
                return v;
            });
        }

        for (int[] e: blueEdges) {
            be.compute(e[0], (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(e[1]);
                return v;
            });
        }

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
        }

        dfs(re, be, dp, 0, true, 0);
        dfs(re, be, dp, 0, false, 0);

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int[] node = dp[i];
            int min = Math.min(dp[i][0], dp[i][1]);
            res[i] = min < Integer.MAX_VALUE ? min : -1;
        }
        return res;
    }

    private void dfs(
        Map<Integer, List<Integer>> re,
        Map<Integer, List<Integer>> be,
        int[][] dp,
        int i,
        boolean red,
        int steps
    ) {
        if (red && steps >= dp[i][0]
        || !red && steps >= dp[i][1]) {
            return;
        }

        if (red) {
            dp[i][0] = steps;
        } else {
            dp[i][1] = steps;
        }

        if (red && re.containsKey(i)) {
            for (var e: re.get(i)) {
                dfs(re, be, dp, e, false, steps+1);
            }
        }
        if (!red && be.containsKey(i)) {
            for (var e: be.get(i)) {
                dfs(re, be, dp, e, true, steps+1);
            }
        }
    }
}
