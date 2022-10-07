class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> row = new HashMap();
        Map<Integer, List<Integer>> column = new HashMap();
        
        for (int i = 0; i < stones.length; i++) {
            int[] s = stones[i];
            if (!row.containsKey(s[0])) {
                row.put(s[0], new LinkedList());
            }
            row.get(s[0]).add(i);
            
            if (!column.containsKey(s[1])) {
                column.put(s[1], new LinkedList());
            }
            column.get(s[1]).add(i);
        }
        
        int res = 0;
        boolean[] visited = new boolean[stones.length];
        
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                dfs(i, stones, row, column, visited);
                res++;
            }
        }
        return stones.length - res;
    }
    
    private void dfs(int i, int[][] s, Map<Integer, List<Integer>> r, Map<Integer, List<Integer>> c, boolean[] v) {
        v[i] = true;
        int[] stone = s[i];
        for (int j: r.get(stone[0])) {
            if (!v[j]) {
                dfs(j, s, r, c, v);
            }
        }
        for (int j: c.get(stone[1])) {
            if (!v[j]) {
                dfs(j, s, r, c, v);
            }
        }
    }
}
