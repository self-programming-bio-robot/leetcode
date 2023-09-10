public class CombinationSumIV377 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new int[] {1,2,3},
                4,
                7
            ),
            new TestCase(
                new int[] {9},
                3,
                0
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().combinationSum4(c.nums, c.target);
            System.out.println("actual " + actual);
            if (actual != c.expected) {
                System.out.println("Error");
                return;
            }
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
        sb.append(nums);
        sb.append("\n");
        sb.append(target);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}
