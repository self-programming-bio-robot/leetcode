import java.util.List;
import java.util.LinkedList;

public class FindAllAnagramsInAString438 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("cbaebabacd", "abc", List.of(0,6)),
            new TestCase("abab", "ab", List.of(0,1,2)),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            List<Integer> actual = new Solution().findAnagrams(c.s, c.p);
            System.out.println("actual " + actual);
            if (!c.expected.equals(actual)) return;
        }
    }
}

class TestCase {
    public String s;
    public String p;
    public List<Integer> expected;

    public TestCase(String s, String p, List<Integer> expected) {
        this.s = s;
        this.p = p;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(s).append(" ").append(p);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList();
        if (p.length() > s.length()) return res;

        int[] rawHashS = new int[26];
        int[] rawHashP = new int[26];

        for (int i = 0; i < p.length(); i++) {
            rawHashS[s.charAt(i) - 'a']++;
            rawHashP[p.charAt(i) - 'a']++;
        }

        if (check(rawHashS, rawHashP)) res.add(0);

        for (int i = 1; i <= s.length() - p.length(); i++) {
            rawHashS[s.charAt(i + p.length() - 1)-'a']++;
            rawHashS[s.charAt(i-1)-'a']--;
            if (check(rawHashS, rawHashP)) res.add(i);
        }

        return res;
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
