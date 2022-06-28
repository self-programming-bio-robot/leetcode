import java.util.Arrays;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique1647 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("aaabbbcc", 2),
            new TestCase("ceabaacb", 2),
            new TestCase("aab", 0),
            new TestCase("accdcdadddbaadbc", 1),
            new TestCase("abcabc", 3),
            new TestCase("jbddhjemmnhaflahionjoddojoliimdcailihfdleahgbafnknblkheeicoonffenhhmgfhgmnjk", 39)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().minDeletions(c.arg1);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public String arg1;
    public int expected;

    public TestCase(String arg1, int expected) {
        this.arg1 = arg1;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(arg1);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int minDeletions(String s) {
        int[] counts = new int[26];
        for (char c: s.toCharArray()) {
            counts[c - 'a'] += 1;
        }

        Arrays.sort(counts);

        int max = s.length();
        int res = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] > max) {
                res += counts[i] - max;
                counts[i] = max;
            }
            max = Math.max(0, counts[i] - 1);
        }

        return res;
    }
}
