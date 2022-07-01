import java.util.Arrays;

public class MaximumUnitsOnATruck1710 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[][] {{1,3},{2,2},{3,1} }, 4, 8),
            new TestCase(new int[][] {{5,10},{2,5},{4,7},{3,9}}, 10, 91)    
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().maximumUnits(c.boxes, c.truckSize);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int[][] boxes;
    public int truckSize;
    public int expected;

    public TestCase(int[][] boxes, int truckSize, int expected) {
        this.boxes = boxes;
        this.expected = expected;
        this.truckSize = truckSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ")
            .append(truckSize)
            .append(" [");
        for (int[] x: boxes) {
            sb.append("[")
                .append(x[0])
                .append(",")
                .append(x[1])
                .append("],");
        }
        sb.append("]\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] d = new int[1001];
        
        for (int[] x: boxTypes) {
            d[x[1]] += x[0];
        }

        int sum = 0;
        int count = truckSize;
        for (int i = 1000; i > 0; i--) {
            int mul = Math.min(count, d[i]);
            sum += mul * i;
            count -= mul;
            if (count == 0) return sum;
        }

        return sum;
    }
}
