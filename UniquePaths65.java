public class UniquePaths65 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(3, 7, 28),
            new TestCase(3, 2, 3),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().uniquePaths(c.m, c.n);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int n;
    public int m;
    public int expected;

    public TestCase(int m, int n, int  expected) {
        this.n = n;
        this.m = m;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(n).append(" ").append(m);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[m+1];
        row[1] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                row[i] += row[i-1];
            }
        }
        return row[m];
    }
}
