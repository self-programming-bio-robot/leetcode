import java.util.Arrays;
import java.util.stream.Collectors;

public class WhereWilltheBallFall1706 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                    new int[][] {
                        {1,1,1,-1,-1},
                        {1,1,1,-1,-1},
                        {-1,-1,-1,1,1},
                        {1,1,1,1,-1},
                        {-1,-1,-1,-1,-1}
                    },            
                    new int[] {1,-1,-1,-1,-1}
            ),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int[] actual = new Solution().findBall(c.field);
            System.out.println("actual " + Arrays.stream(actual)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(",")));
            if (Arrays.equals(c.expected, actual)) return;
        }
    }
}

class TestCase {
    public int[][] field;
    public int[] expected;

    public TestCase(int[][] field, int[]  expected) {
        this.field = field;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        for (int[] line: field) {
            sb.append("[");
            sb.append(Arrays.stream(line).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
            sb.append("],");
        }
        sb.append("\n");
        sb.append("expected: ");
        sb.append(Arrays.stream(expected).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
        return sb.toString();
    }
}

class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) result[i] = i;
        for (int j = 0; j < n; j++) {
            System.out.println(Arrays.stream(result).mapToObj(String::valueOf)
                    .collect(Collectors.joining(",")));
            for (int i = 0; i < m; i++) {
                if (result[i] != -1) {
                    if (grid[j][result[i]] == 1) { // right span
                        result[i] = (result[i] < m-1 && grid[j][result[i] + 1] == 1) 
                            ? result[i] + 1 : -1;
                    } else { // left span
                        result[i] = (result[i] > 0 && grid[j][result[i] - 1] == -1) 
                            ? result[i] - 1 : -1;
                    }
                }
            }
        }
        return result; 
    }
}
