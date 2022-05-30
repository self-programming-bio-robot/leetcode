import java.util.ArrayList;

public class DivideTwoIntegers29 {
    public static void main(String[] args) {
        System.out.println(new Solution().divide(-2147483648, -1));   
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        long[] mul = new long[50];
        int i = 1;
        mul[0] = b;
        while (mul[i - 1] < a) {
            mul[i] = mul[i-1] << 1;
            i++;
        }
        long res = 0;
        i--;
        while (a >= b) {
            if (a < mul[i]) {
                i--;
            } else {
                a -= mul[i];
                res += 1L << i;
            }
        }

        long answer = (dividend < 0) ^ (divisor < 0) ? -res : res;
        answer = answer > Integer.MAX_VALUE ? Integer.MAX_VALUE : answer;
        return  (int)answer;
    }
}
