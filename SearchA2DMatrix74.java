class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int k = matrix[0].length;
        int n = matrix.length * k;
        int l = 0;
        int r = n;
        while (l + 1 < r) {
            int m = (l + r) / 2;
            
            if (matrix[m / k][m % k] > target) {
                r = m;
            } else {
                l = m;
            }
        }
        
        return matrix[l / k][l % k] == target;
    }
}
