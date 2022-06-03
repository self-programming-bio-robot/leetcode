public class RangeSumQuery2DImmutable304 {
    public static void main(String[] args) {
        int[][] matrix = {
            { 3, 0, 1, 4, 2 },
            { 5, 6, 3, 2, 1 },
            { 1, 2, 0, 1, 5 },
            { 4, 1, 0, 1, 7 },
            { 1, 0, 3, 0, 5 }
        };

        int[][] tasks = {
            { 2, 1, 4, 3, 8 },
            { 1, 1, 2, 2, 11 },
            { 1, 2, 2, 4, 12 }
        };

        NumMatrix solver = new NumMatrix(matrix);
        for (int i = 0; i < tasks.length; i++) {
            System.out.println("Exepted " + tasks[i][4] + ", actual: " 
                    + solver.sumRegion(tasks[i][0], tasks[i][1], 
                        tasks[i][2], tasks[i][3]));
        }
    }
}

class NumMatrix {

    private int[][] sum;    
    private int n;
    private int m;

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        sum = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int top = i > 0 ? sum[i - 1][j] : 0;
                int left = j > 0 ? sum[i][j -1] : 0;
                int topLeft = (i > 0 && j > 0) ? sum[i - 1][j - 1] : 0;

                sum[i][j] = top + left - topLeft + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top = row1 > 0 ? sum[row1 - 1][col2] : 0;
        int left = col1 > 0 ? sum[row2][col1 -1] : 0;
        int topLeft = (col1 > 0 && row1 > 0) ? sum[row1 - 1][col1 - 1] : 0;

        return sum[row2][col2] - top - left + topLeft;
    }
}
