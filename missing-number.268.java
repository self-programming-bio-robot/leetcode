public class MissingNumber268 {
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{0,1,3}));
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}

