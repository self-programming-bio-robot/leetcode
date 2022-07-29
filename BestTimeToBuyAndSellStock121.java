import java.util.Arrays;
import java.util.stream.Collectors;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] {7,1,5,3,6,4}, 5),
            new TestCase(new int[] {23, 75, 30, 71, 17, 40, 4}, 52),
            new TestCase(new int[] { 9,7,6,5,3,1 }, 0)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().maxProfit(c.prices);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int[] prices;
    public int expected;

    public TestCase(int[] prices, int expected) {
        this.prices = prices;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(Arrays.stream(prices)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        
        int min = prices[0];
        int best = 0;

        for (int i = 0; i < prices.length; i++) {
            best = Math.max(prices[i] - min, best);
            min = Math.min(prices[i], min);
        }

        return best;
    }
}
