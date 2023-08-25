public class InterleavingString97 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                "abababababababababababababababababababababababababababababababababababababababababababababababababbb",
                "babababababababababababababababababababababababababababababababababababababababababababababababaaaba",
                "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb",
                false
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            boolean actual = new Solution().isInterleave(c.s1, c.s2, c.s3);
            System.out.println("actual " + actual);
            if (actual != c.expected) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class TestCase {
    public String s1;
    public String s2;
    public String s3;
    public boolean expected;

    public TestCase(String s1, String s2, String s3, boolean expected) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(s1);
        sb.append("\n");
        sb.append(s2);
        sb.append("\n");
        sb.append(s3);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() > s3.length()) {
            return false;
        }
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        return dsf(s1, s2, s3, 0, 0, 0, dp);
    }

    boolean dsf(String s1, String s2, String s3, int i1, int i2, int i, int[][] dp) {
        if (i == s3.length()) {
            return true;
        }
        if (dp[i1][i2] > 0) {
            return dp[i1][i2] == 1;
        }
        char c1 = i1 < s1.length() ? s1.charAt(i1) : 0;
        char c2 = i2 < s2.length() ? s2.charAt(i2) : 0;
        char c3 = s3.charAt(i);
        if (c1 != c3 && c2 != c3) {
            return false;
        }
        boolean res = false;
        if (c1 == c3) {
            res = dsf(s1, s2, s3, i1+1, i2, i+1, dp);
        } 
        if (!res && c2 == c3) {
            res = dsf(s1, s2, s3, i1, i2+1, i+1, dp);
        }

        dp[i1][i2] = res ? 1 : 2;
        return res;
    } 
}
