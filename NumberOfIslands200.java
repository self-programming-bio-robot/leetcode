public class NumberOfIslands200 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                    new char[][] {
                        new char[] {'1','1','1','1','0'},
                        new char[] {'1','1','0','1','0'},
                        new char[] {'1','1','0','0','0'},
                        new char[] {'0','0','0','0','0'},
                    },
                    1
            ),
            new TestCase(
                    new char[][] {
                        new char[] {'1','1','0','0','0'},
                        new char[] {'1','1','0','0','0'},
                        new char[] {'0','0','1','0','0'},
                        new char[] {'0','0','0','1','1'},
                    },
                    3
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().numIslands(c.grid);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public char[][] grid;
    public int expected;

    public TestCase(char[][] grid, int expected) {
        this.grid = grid;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: \n");
        for (char[] r: grid) {
            for (char c: r) {
                sb.append(c).append(',');
            }
            sb.append("\n");
        }
        sb.append("\n");    
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    sizeOfIsland(grid, i, j, n, m);
                    res++;
                }
            }
        }
        return res;
    }

    private void sizeOfIsland(char[][] grid, int i, int j, int n, int m) {
        grid[i][j] = '2';
        if (i > 0 && grid[i-1][j] == '1') sizeOfIsland(grid, i-1, j, n, m); 
        if (i < m-1 && grid[i+1][j] == '1') sizeOfIsland(grid, i+1, j, n, m); 
        if (j > 0 && grid[i][j-1] == '1') sizeOfIsland(grid, i, j-1, n, m); 
        if (j < n-1 && grid[i][j+1] == '1') sizeOfIsland(grid, i, j+1, n, m); 
    }
}
