class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] mem = new double[query_row+1][query_row+1];
        for (double[] row : mem) {
            Arrays.fill(row, -1);
        }
        mem[0][0] = poured;
        double res = rec(query_row, query_glass, mem);

        return res >= 1.0 ? 1.0 : res;
    }

    double rec(int row, int glass, double[][] mem) {
        if (mem[row][glass] > -1) {
            return mem[row][glass];
        }

        double exceed = 0;
        if (glass > 0) { // left
            exceed += Math.max((rec(row - 1, glass - 1, mem) - 1) / 2.0, 0);
        }
        if (glass < row) { // right
            exceed += Math.max((rec(row - 1, glass, mem) - 1) / 2.0, 0);
        }
        mem[row][glass] = exceed;
        return exceed;
    }
}
