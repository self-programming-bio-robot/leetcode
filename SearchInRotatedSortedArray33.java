class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int shift = -1;
        
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[(m + nums.length + 1) % nums.length] > nums[m] 
                && nums[(m + nums.length - 1) % nums.length] > nums[m]) {
                shift = m;
                break;
            }
            if (nums[r] > nums[m]) {
                r = m - 1;    
            } else {
                l = m + 1;
            }
        }
        if (shift == -1) shift = l;        
        
        l = 0;
        r = nums.length - 1;
        while (l + 1 < r) {
            int m = (l + r) / 2;
            int ms = (m + shift) % nums.length;
            if (nums[ms] > target ) {
                r = m;    
            } else {
                l = m;
            }
        }
        
        l = (l + shift) % nums.length;
        r = (r + shift) % nums.length;
        
        return nums[l] == target ? l
            : (nums[r] == target ? r : -1);
    }
}
