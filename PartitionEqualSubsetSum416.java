class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i: nums) {
            sum += i; 
        }
        if ((sum & 1) == 1) return false;
        sum = sum >> 1;
        boolean[] bits = new boolean[sum + 1]; 

        for (int num: nums) {
            for (int i = sum; i > 0; i--) {
                bits[i] = bits[i] || i == num || i > num && bits[i - num];
            }
        }
        
        return bits[sum];
    }
}
