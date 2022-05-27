public class NumberOfStepsToReduceANumberToZero1342 {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSteps(14));
    }
}

class Solution {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int res = -1;
        while (num > 0) {
            res += (num & 1) + 1;
            num = num >> 1;
        }
        return res;
    }
}
