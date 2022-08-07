import java.util.PriorityQueue;
import java.util.List;
import java.util.LinkedList;

public class MatchsticksToSquare473 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] { 1, 1, 2, 2, 2 }, true),
            new TestCase(new int[] { 3, 3, 3, 3, 4 }, false),
            new TestCase(new int[] { 2, 3, 5, 5, 1, 1, 1, 1, 1 }, true),
            new TestCase(new int[] {5,5,5,5,4,4,4,4,3,3,3,3}, true)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            boolean actual = new Solution().makesquare(c.matchsticks);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int[] matchsticks;
    public boolean expected;

    public TestCase(int[] matchsticks, boolean expected) {
        this.matchsticks = matchsticks;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        for (int x: matchsticks) sb.append(x).append(",");
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public boolean makesquare(int[] matchsticks) {
        long sum = 0;
        for (int x: matchsticks) sum += x;
        if (sum % 4 > 0) return false;
        sum /= 4;

        PriorityQueue<Long> q = new PriorityQueue();
        q.add(0L);
        q.add(0L);
        q.add(0L);
        q.add(0L);
        
        for (int x: matchsticks) {
            long small = q.poll();

            List<Long> buf = new LinkedList();
            while (!q.isEmpty() && small + x > sum) {
                buf.add(small);
                small = q.poll();
            }
            
            if (small + x > sum) {
                return false;
            } else {
                q.add(small + x);
                q.addAll(buf);
            }
        }

        return q.stream().mapToLong(Long::valueOf).sum() == sum* 4;
    }
}
