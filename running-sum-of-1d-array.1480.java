public class RunningSumOf1dArray1480 {
    public static void main(String[] args) {
        int[] result = new Solution().runningSum(new int[] { 1, 2, 3, 4 });

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

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
