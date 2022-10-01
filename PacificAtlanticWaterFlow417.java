class Solution {
    private static int A = 1;
    private static int P = 2;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<Point> q = new LinkedList();
        int n = heights.length-1;
        int m = heights[0].length-1;
        int[][] v = new int[n+1][m+1];
        List<List<Integer>> res = new LinkedList();
        
        for (int i = 0; i <= n; i++) {
            q.add(new Point(i, 0, P));
            q.add(new Point(i, m, A));
        }
        for (int i = 0; i <= m; i++) {
            q.add(new Point(0, i, P));
            q.add(new Point(n, i, A));
        }
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            if ((v[p.i][p.j] & p.t) != 0) continue;
            
            v[p.i][p.j] |= p.t;
                        
            if (v[p.i][p.j] == 3) {
                res.add(List.of(p.i, p.j));
            }
            
            if (p.i > 0 && heights[p.i-1][p.j] >= heights[p.i][p.j])
                q.offer(new Point(p.i-1, p.j, p.t));
            if (p.j > 0 && heights[p.i][p.j-1] >= heights[p.i][p.j])
                q.offer(new Point(p.i, p.j-1, p.t));
            if (p.i < n && heights[p.i+1][p.j] >= heights[p.i][p.j])
                q.offer(new Point(p.i+1, p.j, p.t));
            if (p.j < m && heights[p.i][p.j+1] >= heights[p.i][p.j])
                q.offer(new Point(p.i, p.j+1, p.t));
        }
        return res;
    }
}

class Point {
    public int i;
    public int j;
    public int t;
    
    public Point(int i, int j, int t) {
        this.i = i;
        this.j = j;
        this.t = t;
    }
}
