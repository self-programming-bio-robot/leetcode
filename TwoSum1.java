import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

public class TwoSum1 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] {2,7,11,15}, 9, new int[] {0,1}),
            new TestCase(new int[] {3,2,4}, 6, new int[] {1,2}),
            new TestCase(new int[] {3,3}, 6, new int[] {0,1}),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int[] actual = new Solution().twoSum(c.nums, c.target);
            System.out.println("actual " + Arrays.stream(actual)
                .mapToObj(String::valueOf).collect(Collectors.joining(",")));
            if (!Arrays.equals(actual,c.expected)) return;
        }
    }
}

class TestCase {
    public int[] nums;
    public int target;
    public int[] expected;

    public TestCase(int[] nums, int target, int[] expected) {
        this.nums = nums;
        this.target = target;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(Arrays.stream(nums)
                .mapToObj(String::valueOf).collect(Collectors.joining(",")));
        sb.append(" | ").append(target);
        sb.append("\n");
        sb.append("expected: ")
            .append(Arrays.stream(expected)
                    .mapToObj(String::valueOf).collect(Collectors.joining(",")));
        return sb.toString();
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer first = hashMap.get(target - nums[i]);
            if (first != null) {
                return new int[] {first, i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[] {0, 1}; 
    }
}
