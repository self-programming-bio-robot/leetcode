import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII462 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] {1,2,3}, 2),
            new TestCase(new int[] {1,10,2,9}, 16),
            new TestCase(new int[] {1,0,0,8,6}, 14)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().minMoves2(c.arr);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int[] arr;
    public int expected;

    public TestCase(int[] arr, int expected) {
        this.arr = arr;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        for (int x: arr)
            sb.append(x).append(",");
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median;
        if ((n & 1) == 1) {
            median = nums[n / 2];    
        } else {
            median = (nums[n / 2] + nums[n / 2 - 1]) / 2;
        }
        
        int res = 0;
        for (int x: nums) {
            res += Math.abs(x - median);
        }
        return res;
    }
}
