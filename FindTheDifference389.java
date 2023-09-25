public class FindTheDifference389 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("abcd", "abcde", 'e'), 
            new TestCase("abccccd", "cacbecdc", 'e')
        };

        for (TestCase c: cases) {
            System.out.println(c);
            char actual = new Solution().findTheDifference(c.s, c.t);
            System.out.println("actual " + actual);
            if (actual != c.expected) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class TestCase {
    public String s;
    public String t;
    public char expected;

    public TestCase(String s, String t, char expected) {
        this.s = s;
        this.t = t;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(s);
        sb.append("\n");
        sb.append(t);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int diff = 0;
        for (char c: s.toCharArray()) {
           diff = diff ^ (int)(c - 'a'); 
        }
        for (char c: t.toCharArray()) {
           diff = diff ^ (int)(c - 'a'); 
        }
        return (char)(diff + 'a');
    }
}
