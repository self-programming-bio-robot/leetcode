import java.util.*;

public class ReorganizeString767 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("aab", "aba")
        };

        for (TestCase c: cases) {
            System.out.println(c);
            String actual = new Solution().reorganizeString(c.arg1);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public String arg1;
    public String expected;

    public TestCase(String arg1, String expected) {
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
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for (char c: s.toCharArray()) {
            counts[c - 'a'] += 1;
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b.count, a.count);
        });
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                q.add(new Pair((char)('a' + i), counts[i]));
            }
        }

        StringBuilder res = new StringBuilder();
        while (q.size() > 1) {
            var n1 = q.poll();
            var n2 = q.poll();

            res.append(n1.c);
            res.append(n2.c);
            if (n1.count > 1) {
                q.add(new Pair(n1.c, n1.count-1));
            }
            if (n2.count > 1) {
                q.add(new Pair(n2.c, n2.count-1));
            }
        }
        var last = q.poll();
        if (last == null || last.count == 1) {
            if (last != null) res.append(last.c);
            return res.toString();
        }
        return "";
    }

    class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
