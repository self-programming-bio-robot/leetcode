class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Point> q = new LinkedList();
        int n = grid.length;
        int m = grid[0].length;
        
        int fresh = findStartedPoints(grid, q);
        
        int res = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            res = Math.max(p.step, res);
            if (p.i > 0 && grid[p.i - 1][p.j] == 1) {
                rotOrange(p.i-1, p.j, p.step+1, q, grid);
                fresh--;
            }
            if (p.i < n - 1 && grid[p.i + 1][p.j] == 1){
                rotOrange(p.i+1, p.j, p.step+1, q, grid);
                fresh--;
            }
            if (p.j > 0 && grid[p.i][p.j - 1] == 1) {
                rotOrange(p.i, p.j-1, p.step+1, q, grid);
                fresh--;
            }
            if (p.j < m - 1 && grid[p.i][p.j + 1] == 1) {
                rotOrange(p.i, p.j+1, p.step+1, q, grid);
                fresh--;
            }
        }
        
        return fresh == 0 ? res : -1;
    }
    
    private void rotOrange(int i, int j, int step, Queue<Point> q, int[][] grid) {
        q.offer(new Point(i, j, step));
        grid[i][j] = 2;
    }
    
    private int findStartedPoints(int[][] grid, Queue<Point> q) {
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Point(i, j, 0));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        return fresh;
    }
}

class Point {
    public int i;
    public int j;
    public int step;
    
    public Point(int i, int j, int step) {
        this.i = i;
        this.j = j;
        this.step = step;
    }
}
