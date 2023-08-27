import java.util.*;

public class MaximumLengthOfPairChain646 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new int[][] {
                    new int[] { 1, 2 }, 
                    new int[] { 2, 3 }, 
                    new int[] { 3, 4 }, 
                },
                2
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().findLongestChain(c.pairs);
            System.out.println("actual " + actual);
            if (actual != c.expected) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class TestCase {
    public int[][] pairs;
    public int expected;

    public TestCase(int[][] pairs, int expected) {
        this.pairs = pairs;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(pairs);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int dp[] = new int[pairs.length];
        int res = 0;
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = i-1; j >=0; j--) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;    
    }
}
