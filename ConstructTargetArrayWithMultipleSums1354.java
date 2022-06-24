import java.util.PriorityQueue;
import java.util.Comparator;

public class ConstructTargetArrayWithMultipleSums1354 {
    public static void main (String[] args) {
        //int[] test = new int[] { 9, 3, 5 }; // true
        //int[] test = new int[] { 1, 1, 1, 2 }; // false
        //int[] test = new int[] { 5, 8 }; // true
        int[] test = new int[] { 1, 1000000000 }; // true
        //int[] test = new int[] { 5, 50 }; // false
        System.out.println("expected: true");
        System.out.println("actual: " + new Solution().isPossible(test));
    }
}

class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }

        PriorityQueue<Integer> q = new PriorityQueue(Comparator.reverseOrder());
        int sum = 0;
        for (int x: target) {
            sum += x;
            q.add(x);
        }

        while (q.peek() != 1) {
            int max = q.poll();
            int next = q.peek();
            int dt = sum - max;
            if (dt == 0) return false;
            
            int mul = Math.max((max - next) / dt, 1);
            int act = max - dt * mul;
            if (act > 0) {
                q.add(act);
                sum -= dt * mul;
            } else {
                return false;
            }
        }
        return true;       
    }
}
