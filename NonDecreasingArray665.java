class Solution {
    public boolean checkPossibility(int[] nums) {
        int min = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                if (min > 0) return false;
                min++;
                if ((i > 0 && i < nums.length-1 && nums[i-1] > nums[i+1]) 
                    && (i > 1 && i < nums.length && nums[i-2] > nums[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
