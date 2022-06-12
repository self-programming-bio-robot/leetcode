import java.util.HashMap;
import java.util.Map;

public class MaximumErasureValue1695 {
    public static void main(String[] args) {
        int nums[] = new int[] { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
        int expected = 8;

        System.out.println("expected: " + expected 
                + " actual: " + new Solution().maximumUniqueSubarray(nums));
    }
}

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> set = new HashMap<>();

        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.containsKey(nums[i])) {
                int prevInd = set.get(nums[i]);
                int setLen = set.size();
                for (int j = i - setLen; j < prevInd; j++) {
                    set.remove(nums[j]);
                    sum -= nums[j];
                }
                set.put(nums[i], i);
            } else {
                set.put(nums[i], i);
                sum += nums[i];
                max = Math.max(sum, max);
            }
        }

        return max;
    }
}
