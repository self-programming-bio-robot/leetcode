import java.util.*;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo1282 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new int[] {3,3,3,3,3,1,3},
                List.of(
                    List.of(0,1,2),
                    List.of(3,4,6),
                    List.of(5)
                )
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            List<List<Integer>> actual = new Solution().groupThePeople(c.groupSize);
            System.out.println("actual " + actual);
            if (c.expected.equals(actual)) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class TestCase {
    public int[] groupSize;
    public List<List<Integer>> expected;

    public TestCase(int[] groupSize, List<List<Integer>> expected) {
        this.groupSize = groupSize;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(Arrays.toString(groupSize));
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Integer>[] groups = new List[groupSizes.length];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (groups[size] == null || groups[size].size() == size) {
                groups[size] = new ArrayList<>();
                result.add(groups[size]);
            }

            groups[size].add(i);
        }
        return result; 
    }
}
