import java.util.*;

public class MinCostToConnectAllPoints1584 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new int[][] {
                    new int[] {3, 12},
                    new int[] {-2, 5},
                    new int[] {-4, 1},
                },
                18
            ),
            new TestCase(
                new int[][] {
                    new int[] {0, 0},
                    new int[] {2, 2},
                    new int[] {3, 10},
                    new int[] {5, 2},
                    new int[] {7, 0},
                },
                20
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().minCostConnectPoints(c.points);
            System.out.println("actual " + actual);
            if (actual != c.expected) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class TestCase {
    public int[][] points;
    public int expected;

    public TestCase(int[][] points, int expected) {
        this.points = points;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        for (int[] row: points) {
            sb.append(Arrays.toString(row));
            sb.append("\n");
        }
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> free = new HashSet<>();
        for (int i = 0; i < points.length; i++) free.add(i);

        PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a.length, b.length);
        });
        q.add(new Edge(0, 0, 0));

        int result = 0;
        
        while (!q.isEmpty() && !free.isEmpty()) {
            Edge c =  q.poll();
            if (!free.contains(c.to)) continue;
            free.remove(c.to);
            result += c.length;

            for (int i: free) {
                q.add(new Edge(c.to, i, length(points[c.to], points[i])));
            }
        }

        return result; 
    }

    private int length(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    static class Edge {
        public int from;
        public int to;
        public int length;

        Edge(int from, int to, int length) {
            this.from = from;
            this.to = to;
            this.length = length;
        }
    }
}
