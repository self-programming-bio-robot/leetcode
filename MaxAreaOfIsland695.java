public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[][] {
                    new int[] {0,0,1,0,0,0,0,1,0,0,0,0,0},
                    new int[] {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    new int[] {0,1,1,0,1,0,0,0,0,0,0,0,0},
                    new int[] {0,1,0,0,1,1,0,0,1,0,1,0,0},
                    new int[] {0,1,0,0,1,1,0,0,1,1,1,0,0},
                    new int[] {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    new int[] {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    new int[] {0,0,0,0,0,0,0,1,1,0,0,0,0}
            }, 6)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().maxAreaOfIsland(c.grid);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int[][] grid;
    public int expected;

    public TestCase(int[][] grid, int expected) {
        this.grid = grid;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case:\n");
        for (int[] row: grid) {
            for (int x: row) {
                sb.append(x).append(",");
            }
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(sizeOfIsland(grid, i, j, n, m), max);
                }
            }
        }
        return max;
    }

    private int sizeOfIsland(int[][] grid, int i, int j, int n, int m) {
        int sum = 1;
        grid[i][j] = 2;
        int top = i > 0 && grid[i-1][j] == 1 ? sizeOfIsland(grid, i-1, j, n, m) : 0; 
        int bottom = i < m-1 && grid[i+1][j] == 1 ? sizeOfIsland(grid, i+1, j, n, m) : 0; 
        int left = j > 0 && grid[i][j-1] == 1 ? sizeOfIsland(grid, i, j-1, n, m) : 0; 
        int right = j < n-1 && grid[i][j+1] == 1 ? sizeOfIsland(grid, i, j+1, n, m) : 0; 
        return sum + top + bottom + left + right;
    }
}
