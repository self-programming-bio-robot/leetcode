public class FibonacciNumber509 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(0, 0),
            new TestCase(1, 1),
            new TestCase(2, 1),
            new TestCase(3, 2),
            new TestCase(4, 3),
            new TestCase(5, 5),
            new TestCase(6, 8),
            new TestCase(7, 13),
            new TestCase(8, 21),
            new TestCase(9, 34)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().fib(c.n);
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
    public int fib(int n) {
        double f = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round((Math.pow(f, n) - Math.pow(-f, -n)) / (2*f - 1));
    }
}
