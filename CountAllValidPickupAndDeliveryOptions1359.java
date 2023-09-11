public class CountAllValidPickupAndDeliveryOptions1359 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(1,1),
            new TestCase(2,6),
            new TestCase(3,90)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().countOrders(c.n);
            System.out.println("actual " + actual);
            if (actual != c.expected) {
                System.out.println("Error");
                return;
            }
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
    public int countOrders(int n) {
        int count = 1;

        for (int i = 2; i <= n; i++) {
            count *= (2*i - 1) * i % 1_000_000_007;
        }

        return count; 
    }
}
