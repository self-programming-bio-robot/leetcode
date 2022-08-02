import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill733 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new int[][] {
                    new int[] { 1, 1, 1 },
                    new int[] { 1, 1, 0 },
                    new int[] { 1, 0, 1 }
                },
                1, 1, 2,
                new int[][] {
                    new int[] { 2, 2, 2 },
                    new int[] { 2, 2, 0 },
                    new int[] { 2, 0, 1 }
                }
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int[][] actual = new Solution().floodFill(c.image, c.sr, c.sc, c.color);
            System.out.println("actual:\n" + TestCase.imageToString(actual));
            if (!Arrays.equals(actual, c.expected)) return;
         }
    }
}

class TestCase {
    public int[][] image;
    public int sr;
    public int sc;
    public int color;
    public int[][] expected;

    public TestCase(int[][] image, int sr, int sc, int color, int[][] expected) {
        this.image = image;
        this.sr = sr;
        this.sc = sc;
        this.color = color;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: \n");
        sb.append(imageToString(image));
        sb.append("\n");
        sb.append("expected: \n").append(imageToString(expected));
        return sb.toString();
    }

    public static String imageToString(int[][] image) {
        return Arrays.stream(image)
            .map(row -> Arrays.stream(row)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(",")))
            .collect(Collectors.joining("\n"));
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        Queue<Point> q = new LinkedList();
        q.add(new Point(sr, sc));

        int baseColor = image[sr][sc];
        while (!q.isEmpty()) {
            Point p = q.poll();

            if (image[p.r][p.c] != color) {
                image[p.r][p.c] = color;

                if (p.r > 0 && image[p.r-1][p.c] == baseColor) 
                    q.add(new Point(p.r-1, p.c));
                if (p.r < n-1 && image[p.r+1][p.c] == baseColor) 
                    q.add(new Point(p.r+1, p.c));
                if (p.c > 0 && image[p.r][p.c-1] == baseColor) 
                    q.add(new Point(p.r, p.c-1));
                if (p.c < m-1 && image[p.r][p.c+1] == baseColor) 
                    q.add(new Point(p.r, p.c+1));
            }
        }

        return image;       
    }
}

class Point {
    public int r;
    public int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
