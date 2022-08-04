import java.util.Arrays;
import java.util.stream.Collectors;

public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] {10,15,20}, 15),
            new TestCase(new int[] {1,100,1,1,1,100,1,1,100,1}, 6)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().minCostClimbingStairs(c.costs);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int[] costs;
    public int expected;

    public TestCase(int[] costs, int expected) {
        this.costs = costs;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(Arrays.stream(costs).mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < cost.length; i++) {
            int c = Math.min(a + cost[i], b + cost[i]);
            a = b;
            b = c;
        }
        return Math.min(a, b);
    }
}
