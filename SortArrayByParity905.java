import java.util.*;

public class SortArrayByParity905 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new int[] {3,1,2,4},
                new int[] {2,4,3,1}
            ),
            new TestCase(
                new int[] {0},
                new int[] {0}
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int[] actual = new Solution().sortArrayByParity(c.nums);
            System.out.println("actual " + Arrays.toString(actual));
            if (!Arrays.equals(actual,c.expected)) {
                System.out.println("Error");
                return;
            }
        }
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
        sb.append(Arrays.toString(nums));
        sb.append("\n");
        sb.append("expected: ").append(Arrays.toString(expected));
        return sb.toString();
    }
}

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int offset = 0;
        int swap = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                offset++;
            } else {
                swap = nums[i];
                nums[i] = nums[i-offset];
                nums[i-offset] = swap;
            }
        }
        return nums; 
    }
}
