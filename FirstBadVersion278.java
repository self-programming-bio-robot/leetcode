public class FirstBadVersion278 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(5, 4, 4),
            new TestCase(1, 1, 1),
            new TestCase(2126753390, 1702766719, 1702766719)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            Solution solution = new Solution();
            solution.bad = c.bad;
            int actual = solution.firstBadVersion(c.n);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int n;
    public int bad;
    public int expected;

    public TestCase(int n, int bad, int expected) {
        this.n = n;
        this.bad = bad;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(n);
        sb.append(", bad = ").append(bad);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class VersionControl {
    public int bad;

    boolean isBadVersion(int version) {
        return version >= bad;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
