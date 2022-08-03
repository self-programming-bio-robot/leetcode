public class ClimbingStairs70 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(2, 2),
            new TestCase(3, 3),
            new TestCase(4, 5),
            new TestCase(5, 8),
            new TestCase(1, 1)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().climbStairs(c.n);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int n;
    public int expected;

    public TestCase(int n, int expected) {
        this.n = n;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(n);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int climbStairs(int nn) {
        int n = nn+1;
        double f = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round((Math.pow(f, n) - Math.pow(-f, -n)) / (2*f - 1));
    }
}
