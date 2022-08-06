public class LongestRepeatingCharacterReplacement424 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("ABAB", 2, 4),
            new TestCase("AABABBA", 1, 4),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().characterReplacement(c.str, c.k);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public String str;
    public int k;
    public int expected;

    public TestCase(String str, int k, int expected) {
        this.str = str;
        this.k = k;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(str);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int window = 0;
        int max = 0;
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, ++cnt[s.charAt(i) - 'A']);
            if (window - max < k) {
                window++;
            } else {
                cnt[s.charAt(i - window) - 'A']--;
            }
        }
        return window;
    }
}
