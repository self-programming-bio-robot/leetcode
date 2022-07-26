import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings205 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("egg", "add", true),
            new TestCase("foo", "bar", false),
            new TestCase("paper","title", true),
            new TestCase("badc","baba", false)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            boolean actual = new Solution().isIsomorphic(c.s, c.t);
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
        sb.append(" ").append(t);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> conformity = new HashMap(); 
        Set<Character> available = new HashSet();

        for (int i = 0; i < s.length(); i++) {
            Character expected = conformity.get(s.charAt(i));
            if (expected == null) {
                if (available.contains(t.charAt(i))) return false;
                conformity.put(s.charAt(i), t.charAt(i));
                available.add(t.charAt(i));
            } else {
                if (t.charAt(i) != expected) return false;
            }
        }
        return true;
    }
}
