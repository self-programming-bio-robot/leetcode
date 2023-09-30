class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int[] minl = new int[nums.length];
        minl[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minl[i] = Math.min(minl[i-1], nums[i-1]);
        }

        LinkedList<Integer> st = new LinkedList<>();

        for (int i = n-1; i > 0; i--) {
            while (!st.isEmpty() && st.peek() <= minl[i]) {
                st.poll();
            }
            if (nums[i] > minl[i] && st.peek() != null && st.peek() < nums[i]) {
                return true;
            }
            st.push(nums[i]);
        }

        return false;
    }
}
