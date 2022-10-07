class Solution {
    public int findCircleNum(int[][] isConnected) {       
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) continue;
            res++;
            dfs(i, isConnected, visited);
        }
        
        return res;
    }
    
    private void dfs(int i, int[][] g, boolean[] v) {
        v[i] = true;
        for (int j = 0; j < g.length; j++) {
            if (!v[j] && g[i][j] == 1) {
                dfs(j, g, v);
            }
        }
    }
}
