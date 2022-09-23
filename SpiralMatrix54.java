class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0;
        int t = 0;
        int b = matrix.length - 1;
        int r = matrix[0].length - 1;
        List<Integer> res = new LinkedList();
        
        while (l <= r && t <= b) {
            System.out.println(l + " " + r + " " + t + " " + b);
            for (int i = l; i <= r; i++) res.add(matrix[t][i]);
            for (int i = t+1; i <= b; i++) res.add(matrix[i][r]);
            if (t < b) for (int i = r-1; i >= l; i--) res.add(matrix[b][i]);
            if (l < r) for (int i = b-1; i >= t+1; i--) res.add(matrix[i][l]);
            l++;t++;b--;r--;
        }
        
        return res;
    }
}
