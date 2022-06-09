public class TwoSumII167 {
    public static void main(String[] args) {
        int[] res = new Solution().twoSum(new int[] { -1, 0 }, -1);
        System.out.println(res[0] + " " + res[1]);
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length && numbers[i] <= target / 2; i++) {
            int pair = bs(numbers, target - numbers[i], i + 1, numbers.length-1);
            if (numbers[i] + numbers[pair] == target) {
                return new int[] { i + 1, pair + 1 };
            }
        }

        return null;
    }

    private int bs(int[] n, int t, int l, int r) {
        while (l < r) {
            int m = (l + r) / 2;
            if (n[m] < t) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
