class Solution {
    public int uniquePaths(int m, int n) {
        int[][] field = new int[m][n];
        if (m == 1 || n == 1) {
            return 1;
        }
        for (int i = 0; i < m; i++) {
            field[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            field[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                field[i][j] = field[i-1][j] + field[i][j-1];
            }
        }
        return field[m-1][n-1];
    }
}
