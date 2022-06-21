import java.util.PriorityQueue;
import java.util.Comparator;

public class FurthestBuildingYouCanReach1642 {
    public static void main (String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] {4,2,7,6,9,14,12}, 5, 1, 4),
            new TestCase(new int[] {4,12,2,7,3,18,20,3,19}, 10, 2, 7),
            new TestCase(new int[] {14,3,19,3}, 17, 0, 3),
            new TestCase(new int[] {1,13,1,1,13,5,11,11}, 10, 8, 3),
        };

        Solution solution = new Solution();
        for (TestCase c: cases) {
            System.out.println(c);
            System.out.println("actual " 
                    + solution.furthestBuilding(c.heights, c.bricks, c.ladders));
        }
    }
}

class TestCase {
    int[] heights;
    int bricks;
    int ladders;
    int excepted;

    public TestCase(
        int[] heights,
        int bricks,
        int ladders,
        int excepted
    ) {
        this.heights = heights;
        this.bricks = bricks;
        this.ladders = ladders;
        this.excepted = excepted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("In:");
        sb.append(" heights = ");
        for (int i: heights)
            sb.append(i).append(" ");
        sb.append(" bricks = ").append(bricks);
        sb.append(" ladders = ").append(ladders);
        sb.append("\n");
        sb.append("excepted: ").append(excepted);
        return sb.toString();
    }
}

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> bmax = new PriorityQueue(Comparator.reverseOrder());
        
        for (int i = 1; i < heights.length; i++) {
            int dt = heights[i] - heights[i-1];
            if (dt > 0) {
                if (bricks >= dt) {
                    bricks -= dt;
                    bmax.add(dt);
                } else {
                    if (ladders > 0 && (bmax.size() == 0 || bmax.peek() <= dt)) { // install ladder here
                        ladders--;
                        continue;
                    }
                    
                    if (ladders > 0) { // change bricks to ladder
                        ladders--;
                        bricks += bmax.poll() - dt;
                        bmax.add(dt);
                        continue;
                    }
                    
                    return i - 1;
                }
            }
        }

        return heights.length - 1; 
    }
}
