import java.util.Arrays;
import java.util.stream.Collectors;

public class RunningSumOf1dArray1480 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] {1, 2, 3, 4}, new int[] {1, 3, 6, 10})
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int[] actual = new Solution().runningSum(c.nums);
            System.out.println("actual " + arrayToString(actual));
            if (!Arrays.equals(c.expected, actual)) return;
        }
    }

    public static String arrayToString(int[] arr) {
        return Arrays.stream(arr)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(", "));
    }
}

class TestCase {
    public int[] nums;
    public int[] expected;

    public TestCase(int[] nums, int[] expected) {
        this.nums = nums;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(RunningSumOf1dArray1480.arrayToString(nums));
        sb.append("\n");
        sb.append("expected: ");
        sb.append(RunningSumOf1dArray1480.arrayToString(expected));
        return sb.toString();
    }
}

class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;       
    }
}
