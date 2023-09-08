import java.util.*;

public class PascalsTriangle118 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                5,
                List.of(
                    List.of(1),
                    List.of(1,1),
                    List.of(1,2,1),
                    List.of(1,3,3,1),
                    List.of(1,4,6,4,1)
                )
            ),
            new TestCase(
                1,
                List.of(
                    List.of(1)
                )
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            List<List<Integer>> actual = new Solution().generate(c.rows);
            System.out.println("actual " + actual);
            if (!c.expected.equals(actual)) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class TestCase {
    public int rows;
    public List<List<Integer>> expected;

    public TestCase(int rows, List<List<Integer>> expected) {
        this.rows = rows;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(rows);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> prev = List.of(1);
        result.add(prev);
        int ans = 1;

        for (int i = 2; i <= numRows; i++) {
            List<Integer> current = new ArrayList<>(i+1);
            ans = 1;
            current.add(1);
            for(int j=1;j<i;j++) {
                ans = ans*(i-j);
                ans = ans/j;
                current.add(ans);
            }
            result.add(current);
            prev = current;
        }

        return result; 
    }
}
