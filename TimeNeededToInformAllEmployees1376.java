class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == 0){
                dfs(manager, informTime, i, dp);
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    private int dfs(int[] manager, int[] informTime, int i, int[] dp) {
        if (i == -1) {
            return 0;
        }
        if (dp[i] > 0) {
            return dp[i] + informTime[i];
        }
        int time = dfs(manager, informTime, manager[i], dp);
        dp[i] = time;

        return time + informTime[i];
    }
}
