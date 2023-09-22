public class IsSubsequence392 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("abc", "ahbgdc", true),
            new TestCase("axc", "ahbgdc", false),
            new TestCase("abbc", "ahbgbbdc", true)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            boolean actual = new Solution().isSubsequence(c.s, c.t);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public String s;
    public String t;
    public boolean expected;

    public TestCase(String s, String t, boolean expected) {
        this.s = s;
        this.t = t;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(s);
        sb.append(" ");
        sb.append(t);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c: t.toCharArray()) {
            if (i == s.length()) return true;
            if (c == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }
}
