public class Candy135 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new int[] {1, 0, 2}, 5),
            new TestCase(new int[] {1, 2, 2}, 4),
            new TestCase(new int[] {0,1,0,2}, 6),
            new TestCase(new int[] {1,2,87,87,87,2,1}, 13)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            int actual = new Solution().candy(c.ratings);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public int[] ratings;
    public int expected;

    public TestCase(int[] ratings, int expected) {
        this.ratings = ratings;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        for (int x: ratings) {
            sb.append(x).append(",");
        }
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public int candy(int[] ratings) {
        int res = 0;
        int up = 0;
        int down = 0;
        int dir = 0;

        for (int i = 1; i < ratings.length; i++) {
            int dt = ratings[i] - ratings[i-1];
            
            if (dir > 0 && dt == 0 || dir < 0 && dt >= 0) {
                res += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }

            if (dt < 0) {
                down++;
            } else if (dt > 0) {
                up++;
            } else {
                res++;
            }
            dir = dt;
        }
        return res + 1 + count(up) + count(down) + Math.max(up, down);
    }

    private int count(int i) {
        return (i * (i + 1)) / 2;
    }
}
