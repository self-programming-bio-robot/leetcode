class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int[][] d = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] dirs = new int[][] {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        PriorityQueue<Point> q = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a.e, b.e);
        });

        q.add(Point.of(0, 0, 0));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.i == r-1 && p.j == c-1) {
                return p.e;
            }
            for (int[] dir: dirs) {
                int ni = dir[0] + p.i;
                int nj = dir[1] + p.j;
                if (ni >= 0 && nj >= 0 && ni < r && nj < c) {
                    int eff = Math.max(p.e, Math.abs(heights[ni][nj] - heights[p.i][p.j]));
                    if (d[ni][nj] > eff) {
                        d[ni][nj] = eff;
                        q.add(Point.of(ni, nj, eff));
                    }
                }
            }
        }
        return 0;
    }

    static class Point {
        int i;
        int j;
        int e;

        Point(int i, int j, int e) {
            this.i = i;
            this.j = j;
            this.e = e;
        }
        
        static Point of(int i, int j, int e) {
            return new Point(i,j,e);
        }
    }
}
