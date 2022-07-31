import java.util.Arrays;
import java.util.stream.Collectors;

public class BinarySearch704 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] {-1,0,3,5,9,12}, 9, 4),
            new TestCase(new int[] {-1,0,3,5,9,12}, 2, -1),
            new TestCase(new int[] {5}, 5, 0),
            new TestCase(new int[] {2,5}, 2, 0)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().search(c.nums, c.target);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int[] nums;
    public int target;
    public int expected;

    public TestCase(int[] nums, int target, int expected) {
        this.nums = nums;
        this.target = target;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        sb.append(", ");
        sb.append(target);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[right] == target ? right : -1;
    }
}
