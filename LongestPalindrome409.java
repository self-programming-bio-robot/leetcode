public class LongestPalindrome409 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("abccccdd", 7),
            new TestCase("a", 1)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().longestPalindrome(c.s);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public String s;
    public int expected;

    public TestCase(String s, int expected) {
        this.s = s;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(s);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int longestPalindrome(String s) {
        int[] letters = new int[58];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'A'] += 1;
        }
        
        int odd = 0;
        int even = 0;
        for (int i = 0; i < letters.length; i++) {
            if ((letters[i] & 1) == 1) {
                odd = 1;
                even += letters[i] - 1;
            } else {
                even += letters[i];
            }
        }
        
        return odd + even;
    }
}
