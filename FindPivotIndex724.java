import java.util.Arrays;
import java.util.stream.Collectors;

public class FindPivotIndex724 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] {1,7,3,6,5,6}, 3),
            new TestCase(new int[] {1,2,3}, -1),
            new TestCase(new int[] {2,1,-1}, 0),
            new TestCase(new int[] {-1,-1,-1,-1,-1,0}, 2),
            new TestCase(new int[] {-1,-1,0,1,0,-1}, 4)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().pivotIndex(c.nums);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int[] nums;
    public int expected;

    public TestCase(int[] nums, int expected) {
        this.nums = nums;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(
                Arrays.stream(nums)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "))
        );
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            int left = i > 0 ? nums[i-1] : 0;
            int right = nums[nums.length-1] - nums[i];

            if (left == right) return i;
        }

        return -1;
    }
}
